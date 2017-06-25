# PatelHitesh

# Design

The ParentalControlService requires a reference to a MovieService and a string Comparator to order parental control levels. This is necessary because levels have to be handled as strings. A CallbackMessage is used to display messages to the user, for example, if an error occurs. This is necessary because of the requirement to return a boolean to the calling client and makes it possible to fail safely.

# Dependency Injection

The principle of Dependency Injection (DI) is followed throughout the system. DI is done manually. Using a framework would be overkill due to the simplicity of the system.

# Reference Implementation

A reference implementation with a command line interface (CLI) is provided with a MovieService in the hitesh.sky.service.MovieService package to illustrate how the ParentalControlService may be used in a client.

# Running the Command Line Client

The CLI can be started by using the executing the run gradle task:

mvn spring-boot:run
