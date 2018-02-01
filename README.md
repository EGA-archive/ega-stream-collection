# EGA Stream Collection

This is a collection of Java stream classes performing a variety of cryptographic and caching operations.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine.

### Prerequisites

This project contains code to read encrypted VCF file specified by S3 URLs. To enable that it was necessary to customize the HTSJDK code base. This project has a dependency on that modified code base, which is specified as local maven dependency in the pom.xml file. Getting this code to comile requires first to compile the modified HTSJDK (https://github.com/AlexanderSenf/htsjdk) and then to modify the pom.xml to point to this local jar file.

### Installing

The repository contains pre-compiled jar files with the client. To build it on your local machine, run

```
mvn package
```

This will produce the library  jar file in the /target directory.

## License

This project is licensed under the Apache 2.0 License - see the [LICENSE.md](LICENSE.md) file for details

