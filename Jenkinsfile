pipeline {
   agent any
    triggers {
           pollSCM('H/1 * * * *') // Poll SCM every 5 minutes
       }

   stages {
       stage('Stop and Remove Existing Container') {
           steps {
               script {
                   // Define the name or ID of the existing container
                   def existingContainerName = 'test-jenkins'

                   // Stop and remove the existing container if it exists
                   if (docker.image(existingContainerName).exists()) {
                       docker.image(existingContainerName).stop()
                       docker.image(existingContainerName).remove()
                   }
               }
           }
       }
       stage('Remove Specific Docker Image') {
           steps {
               script {
                   def imageName = 'test-jenkins'  // Replace with the name and tag of the image you want to delete
                   sh "docker rmi $imageName"
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