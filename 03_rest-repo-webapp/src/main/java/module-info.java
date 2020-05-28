
module patternbox.restdata {
	requires java.sql;
	requires java.persistence;
	requires java.validation;
	requires spring.boot;
	requires spring.boot.autoconfigure;
	requires spring.beans;
	requires spring.context;
	requires spring.data.commons;
	requires spring.data.rest.core;
	requires spring.data.jpa;

	opens com.patternbox.restdata;
}
