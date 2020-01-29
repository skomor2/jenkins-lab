def addresses = ['test1.comarch', 'test2.comarch', 'test3.comarch']
job('job2') {

    description 'Build and test the app'
    wrappers {
        timestamps()
        colorizeOutput()
    }
    publishers {
        chucknorris()
        wsCleanup()
    }
    steps {
        for (int i = 0; i < addresses.size(); i++) {
            def string = "ssh clm@" + addresses[i] + "\" shutdown.sh\""
            shell(string)
        }
    }
}
