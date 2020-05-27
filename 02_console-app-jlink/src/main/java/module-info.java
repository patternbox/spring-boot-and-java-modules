// https://medium.com/criciumadev/its-time-migrating-to-java-11-5eb3868354f9
open module patternbox.springboot.modules.console {
	requires spring.boot.autoconfigure;
	requires spring.context;
	requires spring.boot;

	// requires jdk.unsupported;
}
