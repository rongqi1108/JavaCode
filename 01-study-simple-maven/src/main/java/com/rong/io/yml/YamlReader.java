package com.rong.io.yml;

import lombok.extern.slf4j.Slf4j;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
 
@Slf4j
public class YamlReader {
	private static Map<String, Map<String, Object>> properties = new HashMap<>();
	public static Object getValueByKey(String ymlName, String key) {
		Yaml yaml = new Yaml();
		try (InputStream in = YamlReader.class.getClassLoader().getResourceAsStream(ymlName);) {
			properties = yaml.loadAs(in, HashMap.class);
		} catch (Exception e) {
			log.error("Init yaml failed !", e);
		}
		String separator = ".";
		String[] separatorKeys;
		if (key.contains(separator)) {
			separatorKeys = key.split("\\.");
		} else {
			return properties.get(key);
		}
		Map finalValue = new HashMap<>();
		for (int i = 0; i < separatorKeys.length - 1; i++) {
			if (i == 0) {
				finalValue = properties.get(separatorKeys[i]);
				continue;
			}
			if (finalValue == null) {
				break;
			}
			finalValue = (Map) finalValue.get(separatorKeys[i]);
		}
		return finalValue == null ? null : finalValue.get(separatorKeys[separatorKeys.length - 1]);
	}
}