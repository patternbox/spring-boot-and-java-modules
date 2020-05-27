// https://medium.com/criciumadev/its-time-migrating-to-java-11-5eb3868354f9
module patternbox.springboot.modules.console {
	requires spring.boot.autoconfigure;
	requires spring.context;
	requires spring.boot;

	opens com.patternbox.springboot.modules.console;
}
