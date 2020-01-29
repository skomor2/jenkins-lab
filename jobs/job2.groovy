
job('job2') {
    def addresses = ['test1.comarch', 'test2.comarch', 'test3.comarch']
    description 'Build and test the app'
    wrappers {
        timestamps()
        colorizeOutput()
    }
    publishers {
        chucknorris()
    }
    steps {
        for (int i = 0; i < addresses.size(); i++) {
            shell('ssh clm@i "test')
        }

    }

}
