# kotless-test
This project is a sandbox for testing [Kotless](https://github.com/JetBrains/kotless), running on [AWS](https://aws.amazon.com/).

To run locally: `./gradlew local`. Site then available at http://0.0.0.0:8080/      

To deploy to AWS (need credentials and S3-bucket): `./gradlew deploy`

## Todo
- [x] Deploy to AWS
- [x] Deploy to Route 53
- [x] Use HTML DSL
- [ ] Use static resources
- [ ] Replace Kotless DSL with Ktor
- [ ] Make external call to [Oslo Bysykkel](https://oslobysykkel.no/apne-data/sanntid)
- [ ] Use a suspend function
- [ ] Use a database
