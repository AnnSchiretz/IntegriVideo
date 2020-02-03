1. mvn versions:display-dependency-updates -//обновление всех библиотек в проекте
2. mvn clean test -// запуск всех тестов
3. mvn -Dtest=SumTest test -// запуск тестов, находящихся в классе SumTest
4. mvn -f pom1.xml -// запуск альтернативного pom.xml для проекта Calculator
5. mvn -Dtest=SumTest#runTest -DtestProp=NEW_prop_set test -// прокидываем новые данные в тестовый метод
