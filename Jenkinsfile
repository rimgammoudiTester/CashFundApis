pipeline{
agent any

tools{

maven "maventest"}

stages{

stage('Build')
{
steps{
bat 'mvn clean compile'
}

}

stage('Test')
{
steps{
bat 'mvn test'
}

}
}

}