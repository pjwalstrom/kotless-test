# kotless-test
This project is a sandbox for testing [Kotless](https://github.com/JetBrains/kotless), running on [AWS](https://aws.amazon.com/).

## Built With
- [Kotlin](https://kotlinlang.org/)
- [Kotless](https://github.com/JetBrains/kotless)
- [Gradle](https://gradle.org/)

# Getting Started
## Prerequisites
- Java 17

## Installation
1. Clone this repo

1. Run locally, no AWS-account needed. Site then available at http://0.0.0.0:8080/   
`./gradlew local`

1. Create an AWS-account and an S3-bucket, update `build.gradle.kts`. Then deploy to AWS   
`./gradlew deploy`

# Roadmap
- [x] Deploy to AWS
- [x] Deploy to Route 53
- [x] Use HTML DSL
- [x] Use static resources
- [ ] Replace Kotless DSL with Ktor
- [ ] Make external call to [Oslo Bysykkel](https://oslobysykkel.no/apne-data/sanntid)
- [ ] Use a suspend function
- [ ] Use a scheduled event
- [ ] Use permission management
- [ ] Use a database

