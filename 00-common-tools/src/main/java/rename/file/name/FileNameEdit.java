package rename.file.name;

import java.io.File;

/**
 * @Author: RQ
 * @Date: 2023-08-28 17:20:04
 */
public class FileNameEdit {
    public static void main(String[] args) {
        // 指定需要去除的文字
        String removeWords = "【P1】";
        // 指定需要修改的文件所在的目录
        String filePath = "D:\\BaiduNetdiskDownload";
        renameFileNameDelKeyWord(removeWords, filePath);//去除文件名所包含的关键字
        //renameFileNameDelKeyWord("xmindxmind", "xmind", filePath);
        //AllFileNameEditAndMove(removeWords, "", filePath);//批量修改该文件下及子目录下的所有符合的文件名称,并将这些文件全部移动到该目录下
        //AllFileNameEdit(removeWords, "", filePath);//批量修改该文件下及子目录下的所有符合的文件名称

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
     * @param oldStr   旧的关键字
     * @param newStr   新的关键字
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


    public static void AllFileNameEditAndMove(String oldStr, String newStr, String filePath) {
        // 构造文件列表
        File directory = new File(filePath);
        // 获取所有文件和子目录
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                // 如果是目录，则递归处理
                if (file.isDirectory()) {
                    processDirectory(file, oldStr, newStr, filePath);
                } else {
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
    }

    public static void AllFileNameEdit(String oldStr, String newStr, String filePath) {
        // 构造文件列表
        File directory = new File(filePath);
        // 获取所有文件和子目录
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                // 如果是目录，则递归处理
                if (file.isDirectory()) {
                    processDirectoryTwo(file, oldStr, newStr, filePath + File.separator + file.getName());
                } else {
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
    }

    // 递归处理目录
    public static void processDirectory(File directory, String oldStr, String newStr, String filePath) {
        // 获取所有文件和子目录
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                // 如果是目录，则递归处理
                if (file.isDirectory()) {
                    processDirectory(file, oldStr, newStr, filePath);
                } else {
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
    }

    // 递归处理目录
    public static void processDirectoryTwo(File directory, String oldStr, String newStr, String filePath) {
        // 获取所有文件和子目录
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                // 如果是目录，则递归处理
                if (file.isDirectory()) {
                    processDirectoryTwo(file, oldStr, newStr, filePath + File.separator + file.getName());
                } else {
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
    }


}
