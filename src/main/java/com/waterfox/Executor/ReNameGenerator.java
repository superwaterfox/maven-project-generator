package com.waterfox.Executor;

import java.io.File;
import java.util.ArrayList;

import org.junit.Test;

import common.util.file.FileUtils;

public class ReNameGenerator {
	/**
	 * 通过指定位置，进行深度遍历，批量替换
	 */
	@Test
	public void test1() {
		File file = new File(
				"D:\\CH_Work_Station\\Develop\\workspace/maven-project-generator/src/main/java/com/mybatis");
		String content_target = "com.mybatis.dao.";// package
													// org.mybatis.generator.codegen.mybatis3;
		String content_result = "com.zxsf360.web.mapper.mort.";// package
		// com.core.codegen.mybatis3;
		FileUtils.deepFileContentReplace(file, content_target, content_result);
	}
}
