# Mapstruct
MapStruct is a code generator that greatly simplifies the implementation of mappings between Java bean types based on a convention over configuration approach.
### Why we use Mapstruct?
For most applications the  persistence layer must be different than the object we send to client side So, that is the problem that MapStruct solves: Manually creating bean mappers is time-consuming. But the library can generate bean mapper classes automatically.
### Mapstruct implementation

1. adding mapstruct dependency
```
<dependency>
    <groupId>org.mapstruct</groupId>
    <artifactId>mapstruct</artifactId>
    <version>1.4.2.Final</version> 
</dependency>
```
2. we need to set up Mapstruct annotationProcessorPaths section to the configuration part of the maven-compiler-plugin plugin.
```

<plugin>
<groupId>org.apache.maven.plugins</groupId>
<artifactId>maven-compiler-plugin</artifactId>
<version>3.7.0</version>
<configuration>
	<source>1.8</source>
	<target>1.8</target>
	<annotationProcessorPaths>
	<path>
<groupId>org.projectlombok</groupId>
<artifactId>lombok</artifactId>
<version>${lombok.version}</version>
	</path>
	<path>
<groupId>org.mapstruct</groupId>
<artifactId>mapstruct-processor</artifactId>
<version>${org.mapstruct.version}</version>
	</path>
</annotationProcessorPaths>
<compilerArgs>
<compilerArg>
-Amapstruct.defaultComponentModel=spring
</compilerArg>
</compilerArgs>
</configuration>
</plugin>
```
3. in this step we need to create pojo `StudentRegistration` and Dto`StudentRegistrationDTO` classes
4. we need to create the interface that convert Dto and pojo in both ways so we need to create interface `StudentRegistrationMapper` and than writeing a method for converting Dto to pojo and pojo to Dto
```
@Mapper 
public interface StudentRegistrationMapper {
....
```
## Authors
* **Pooya fils** - *Initial work* - [PooyaFils](https://github.com/pooyafils)
