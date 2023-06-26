# UnikAPI

<p align="center">
  <a href="https://github.com/TFSMads/UnikAPI/releases/"><img alt="GitHub all releases" src="https://img.shields.io/github/downloads/TFSMads/UnikAPI/total"></a>
</p>
  
 
<p align="center">
  <a href="https://github.com/TFSMads/UnikAPI/actions"><img alt="GitHub all releases" src="https://img.shields.io/github/workflow/status/TFSMads/UnikAPI/Build"</a>
  <a href="LICENSE"><img src="https://img.shields.io/badge/license-General Public License-green.svg" alt="License"/></a>
</p>

<p align="center">
  <img alt="GitHub code size in bytes" src="https://img.shields.io/github/languages/code-size/TFSMads/UnikAPI">
  <img alt="GitHub repo size" src="https://img.shields.io/github/repo-size/TFSMads/UnikAPI">
  <img src="https://tokei.rs/b1/github/TFSMads/UnikAPI?category=code" alt="Lines of Code"/>
</p>

Info omkring build processen:

Fordi UnikAPI understøtter flere forskellige minecraft klienter. Som har forskelige build systemer som bruger 
forskellige gradlew versioner er det ikke muligt at lave et gradlew multiproject da det kræver at alle subprojects benytter samme gradlew version.

Steps:
 - Først bygges alle subprojects og compiles placeres i mappen merge
 - Når alle subprojects er compiled, vil alle jar filer i merge mappen bleve merget til en
