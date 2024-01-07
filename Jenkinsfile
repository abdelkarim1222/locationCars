pipeline {
agent any
triggers {
pollSCM('*/5 * * * *') // Vérifier toutes les 5 minutes
}
stages {
stage('Checkout') {
steps {
 script {
                    git branch: '*/master', credentialsId: 'abdelkarim', url: 'https://github.com/abdelkarim1222/locationCars.git'
                }
        echo "Récupération du code source"
checkout scm
}
}
stage('Build') {
steps {
echo "Build du projet"

// Ajoutez les commandes de build ici

}
}
stage('Deploy') {
steps {
echo "Déploiement du projet"
// Ajoutez les commandes de déploiement ici
}
}
}
}