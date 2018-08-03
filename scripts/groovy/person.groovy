package groovy

def sayHello() {

    new Person(null, "michael","rock","man", 18,"abcdefg", "http://www.baidu.com", new Date(),new Date())
    person.properties.each {p-> println p.getKey() + "," + p.getValue()}
    println "groovy preparing $person for activity ${person}"
}

/*
age = "aad"
sayHello(age)*/
sayHello()
