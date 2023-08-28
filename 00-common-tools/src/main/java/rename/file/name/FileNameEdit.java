package rename.file.name;

import java.io.File;

/**
 * @Author: RQ
 * @Date: 2023-08-28 17:20:04
 */
public class FileNameEdit {
    public static void main(String[] args) {
        // 指定需要去除的文字
        String removeWords = "【公众号：思雨考研】";
        // 指定需要修改的文件所在的目录
        String filePath = "C:\\Users\\admin\\Desktop\\00.课件";
        //renameFileNameDelKeyWord(removeWords, filePath);//去除关键字
        renameFileNameDelKeyWord("xmindxmind","xmind", filePath);

    }

    /**
     * 批量修改文件名-删除文件名的关键字
     *
     * @param removeWords 包含的关键字
     * @param filePath    文件路径
     */
    public static void renameFileNameDelKeyWord(String removeWords, String filePath) {
        // 遍历目录下的所有文件
        File directory = new File(filePath);
        for (File file : directory.listFiles()) {
            // 判断文件名是否包含指定文字
            if (file.getName().contains(removeWords)) {
                // 获取文件名和扩展名
                String fileName = file.getName();
                int dotIndex = fileName.lastIndexOf(".");
                String extension = fileName.substring(dotIndex + 1);
                // 构造新的文件名
                String newFileName = fileName.replace(removeWords, "");
                // 构造新的文件路径
                String newFilePath = filePath + File.separator + newFileName;
                // 重命名文件
                File newFile = new File(newFilePath);
                if (file.renameTo(newFile)) {
                    System.out.println("Renamed file: " + file.getName() + " to " + newFileName);
                } else {
                    System.out.println("Failed to rename file: " + file.getName());
                }
            }
        }
    }

    /**
     * 批量修改文件名-指定文字替换
     *
     * @param oldStr 旧的关键字
     * @param newStr 新的关键字
     * @param filePath 文件路径
     */
    public static void renameFileNameDelKeyWord(String oldStr, String newStr, String filePath) {
        // 遍历目录下的所有文件
        File directory = new File(filePath);
        for (File file : directory.listFiles()) {
            // 判断文件名是否包含指定文字
            if (file.getName().contains(oldStr)) {
                // 获取文件名和扩展名
                String fileName = file.getName();
                int dotIndex = fileName.lastIndexOf(".");
                String extension = fileName.substring(dotIndex + 1);
                // 构造新的文件名
                String newFileName = fileName.replace(oldStr, newStr);
                // 构造新的文件路径
                String newFilePath = filePath + File.separator + newFileName;
                // 重命名文件
                File newFile = new File(newFilePath);
                if (file.renameTo(newFile)) {
                    System.out.println("Renamed file: " + file.getName() + " to " + newFileName);
                } else {
                    System.out.println("Failed to rename file: " + file.getName());
                }
            }
        }
    }
}
