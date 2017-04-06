// 'node:4.8.2-alpine'
def call() {
// Run all this in a single node
node("docker") {
    //echo "Running on ${nodeName}"
    NotifyWrapper {
      stage ("Project checkout") {
        checkout scm
      }

      docker.image("node").inside {
        sh "node -v"
          NodeBuildStep()
      }
    }
  }
}