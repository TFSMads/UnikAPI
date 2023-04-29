Info omkring build processen:

Fordi UnikAPI understøtter flere forskellige minecraft klienter. Som har forskelige build systemer som bruger 
forskellige gradlew versioner er det ikke muligt at lave et gradlew multiproject da det kræver at alle subprojects benytter samme gradlew version.

Steps:
 - Først bygges alle subprojects og compiles placeres i mappen merge
 - Når alle subprojects er compiled, vil alle jar filer i merge mappen bleve merget til en