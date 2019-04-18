package com.service;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import com.util.ProcessingUtilAgent;

public class LogRetriever {

	ProcessingUtilAgent util = ProcessingUtilAgent.getInstance();

	public List<String> getAllLogs(String dir) {
		dir = util.decodeDir(dir);
		List<String> files = new ArrayList<String>();

		File folder = new File(dir);
		File[] fileArray = folder.listFiles();

		for (File file : fileArray) {
			files.add(file.getName());
		}

		return files;

	}

	public String getLogFile(String fileName, String dir) {
		dir = util.decodeDir(dir);
		URI filePath = new File(dir + "\\" + fileName).toURI();
		StringBuilder contentBuilder = new StringBuilder();
		try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
			stream.forEach(s -> contentBuilder.append(s).append("\n"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return contentBuilder.toString();

	}

}
