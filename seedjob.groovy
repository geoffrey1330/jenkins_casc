// seedjob.groovy

def create_pipeline(String name, String gitUrl) {
    pipelineJob(name) {
        triggers {
            githubPush()
        }
        definition {
            cpsScm {
                scm {
                    git {
                        remote {
                            url(gitUrl)
                        }
                        branches('*/main')
                        scriptPath('Jenkinsfile')
                    }
                }
            }
        }
    }
}

create_pipeline('pipeline_lesson_10', 'https://github.com/geoffrey1330/web_app.git')
