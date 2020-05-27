
module patternbox.springboot.modules.console {
	requires spring.boot.autoconfigure;
	requires spring.context;
	requires spring.boot;

	exports com.patternbox.springboot.modules.console;
	opens com.patternbox.springboot.modules.console;
}
