# Final Presentation

## Entwicklungsprozess

Während der Entwicklung haben wir Features in entsprechenden Feature branches entwickelt. Diese haben wir gereviewed und via pull request gemerged.
 
Dadurch konnten einzelne Entwickler ungestört und parallel an ihren Features arbeiten und diese dann, wenn diese fertig sind, in den Develop Branch mergen.

Zusätzlich wurde der Master Branch gesperrt, so dass man nur via Pull Requests einchecken kann. Dies garantiert, dass die Mindestanzahl der Reviews (kann definiert werden) eingehalten wird.

![Development with Git](DevelopmentWithGit.png)

Das Resultat im Master Branch sieht folgendermassen aus:

![Commits Master](Commits_Master.png)

## Architektur

![Architektur](Structure.png)

## Contributions

| Teammember                         | Contribution                                                      |
|------------------------------------|-------------------------------------------------------------------|
| Yves Beutler                       | Repository, Testing, Entities                                     |
| Sascha Wittwer                     | Project Initialisation, Medication View, Navigator                |
| Boris Djurdjevic                   | Test data, Repository, Data base, Find Bugs                       |
| Joy Wirth                          | Entities, Stammdaten view, MVP, States pattern, Services          |
| Jasmin Thevathas                   | Pinboard View, JDBC, Tests                                        |
| Leandro Lerena <br> (SCRUM Master) | Project initialisation, Repository, Entities, MVP, States pattern |