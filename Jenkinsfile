pipeline {
   agent any
    triggers {
           pollSCM('H/1 * * * *') // Poll SCM every 5 minutes
       }

   stages {
       stage('Stop and Remove Existing Container') {
           steps {
               script {
                    def existingContainerName = 'test-jenkins'
                    try {
                        docker.image(existingContainerName).inside {
                            docker.image(existingContainerName).stop()
                            docker.image(existingContainerName).remove()
                        }
                    } catch (Exception e) {
                        echo 'Docker image does not exist'
                    }
               }
           }
       }
       stage('Remove Specific Docker Image') {
           steps {
               script {
                    try {
                   def imageName = 'test-jenkins'
                   docker.image(imageName).remove(force: true)
                    } catch (Exception e) {
                        echo 'Docker image does not exist'
                    }
               }
           }
       }
       stage('Build Docker Image') {
           steps {
               script {
                   def dockerImage = docker.build('test-jenkins', '-f Dockerfile .')
                   dockerImage.inside('-p 8888:8080') {
                   }
               }
           }
       }
   }
}