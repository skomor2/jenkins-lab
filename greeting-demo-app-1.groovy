job('greeting-demo-app-1') { 
  	description 'Build and test the app'
  	triggers {
      scm('H/2 * * * *')
  }
  wrappers {
    timestamps()
    colorizeOutput()
  }
      publishers {
        chucknorris()
        jacocoCodeCoverage {
          execPattern('build/jacoco')
          exclusionPattern('*Spec.class')
        }
        publishHtml{ 
          report('build/reports/tests/test') {
          	reportName('Report')
          } 
        }
        
    }
    scm {
        git '/home/jenkins/greeting-demo-app'
    }
  

    steps {

	shell 'echo Hello'
	shell 'date > data'
	shell 'git add data'
	shell 'git commit -m data'
	gradle('build')
     
    }
  
}
