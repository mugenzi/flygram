package com.util;

import java.io.File;
import java.nio.file.Files;

import org.apache.commons.io.FilenameUtils;

public class UtilityService {

	public static byte[] readBytesFromFile(File file) throws Exception {
		byte[] fileContent = Files.readAllBytes(file.toPath());
		if (fileContent.length > 429495295)
			throw new Exception("Your File Exceded Allowed Size (4GB)");
		else {
			return fileContent;
		}
	}

	public static String getPostType(String path) {
		try {
			String type = FilenameUtils.getExtension(path).toUpperCase();
			switch (type) {
			case "MP4":
			case "AVI":
			case "VOB:":
			case "3GP":
			case "OGG":
			case "WMV":
			case "WEBM":
			case "FLV":
			case "QUICKTIME":
			case "HDV":
			case "MXF":
			case "MPEG-TS":
			case "MPEG":
			case "WAV":
			case "LXF":
			case "GXF":
				return "video";
			case "JPEG":
			case "JPG":
			case "GIF":
			case "PNG":
			case "JFIF":
			case "EXIF":
			case "TIFF":
			case "BMP":
			case "PPM":
			case "PGM":
			case "PBM":
			case "PNM":
				return "photo";
			default:
				return "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

}
