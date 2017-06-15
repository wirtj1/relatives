# Final Presentation

## Implementation Highlights

### Navigation mit Vaadin

+ Navigator Klasse
+ Parameterübergabe zwischen Views

```java
public class MvpNavigator extends BaseNavigator {
    /**
     * Adds the view to the navigator and optionally also to the menu of the Bootstrapper.
     * @param presenter: Presenter (represents an MVP set) to be observed by the navigator.
     * @param addToMenu: Switch, if the View should be available through the menu.
     */
    public void addView(BasePresenter presenter, VaadinIcons icon, boolean addToMenu) {
        addView(presenter.getView().getViewName(), presenter.getView());
        views.add(presenter.getView());

        if (addToMenu)
        {
            MenuBar.MenuItem firstMenuItem = navigationBar.getItems().get(0);
            navigationBar.addItemBefore(presenter.getView().getCaption(), icon, menuItem -> navigateTo(presenter.getView().getClass()), firstMenuItem);
        }
    }
    
    /**
         * Navigates to the specified View
         * @param destinationView: View to be navigated to
         * @param parameterSet: Parameters to be passed to the view
         * @param <T>: Class extending BaseView
         */
        public <T extends BaseView> void navigateTo(Class<T> destinationView, ParameterSet parameterSet)
        {
            // Navigation to logon view is always possible
            if (getUI().sessionActive() || destinationView.equals(LogonView.class)){
                viewHistory.add(destinationView);
                views.stream()
                        .filter(components -> components.getClass().equals(destinationView))
                        .findFirst()
                        .ifPresent(components -> navigateTo(NavigationUtils.combineNameAndParams(components.getViewName(), parameterSet)));
            } else { // Navigation to other view than logon despite no valid session
                ParameterSet parameter = new ParameterSet();
                parameter.addParameter("timeout", "true");
                viewHistory.add(LogonView.class);
                views.stream()
                        .filter(components -> components.getClass().equals(LogonView.class))
                        .findFirst()
                        .ifPresent(components -> navigateTo(NavigationUtils.combineNameAndParams(components.getViewName(), parameter)));
            }
        }
    
        /**
         * Navigates one step back
         */
        public void navigateBack()
        {
            if (viewHistory.size() > 2){
                // Navigate to last view. Current view is size -1, last view is size -2
                navigateTo(viewHistory.get(viewHistory.size() - 2));
            }
        }
    
        /**
         * Resets Navigation history
         */
        public void resetViewHistory(){
            viewHistory.clear();
        }
    
}
```

### Vaadin Data Binder

+ Databinding mit vaadin Data Binder (package com.vaadin.data;)
+ Databinding mittels Predicated

```java
public abstract class PersonGrid<P extends Person> extends VerticalLayout {
    private Binder<P> binder;
    private P person;
    private TextField firstName = new TextField("Vorname", "");
    
    public PersonGrid(P person) {
        binder = new Binder<>();
        binder.forField(firstName)
        .asRequired("Darf nicht leer sein")
        .bind(Person::getFirstName, Person::setFirstName);
        binder.readBean(patient)
    }    
    
     @Override
     public void onSave(PersonGrid personGrid) {
         //...
         personGrid.getBinder().writeBeanIfValid(personGrid.getPerson());
         //...
     }
}
```

### Generisches Repository

+ Ein generisches Repository dient als Basisklasse für alle spezifischen Repositories

```java

/**
 * @author yvesbeutler
 * Abstract class for the generic repository which provides CRUD functionality.
 */
public abstract class Repository<T extends Identity> {
           public T persist(T obj) {
               em.getTransaction().begin();
       
               if (obj.getId() > 0 ) {
                   em.merge(obj);
               }
               else {
                   em.persist(obj);
               }
       
               em.getTransaction().commit();
               return obj;
           }
           
           /**
            * Removes a given object from the database.
            * @param obj Subtype of {@link Identity}
            * @return true if successfully removed
            */
           public boolean remove(T obj){
               em.getTransaction().begin();
       
               if (em.contains(obj)){
                   em.remove(obj);
                   em.getTransaction().commit();
                   return true;
               }
       
               return false;
           }
           
           /**
            * Finds an object by its ID in the database.
            * @param id the ID used by the database
            * @return Optional to prevent {@link NullPointerException}
            */
           public Optional<T> find(long id){
               T obj = em.find(entityClass, id);
               return Optional.ofNullable(obj);
           }
}

public class PinboardRepository extends Repository<PinBoard> {
    //...
}

```

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

## Lessons learned

### Story board

### Requirements

### Design

### Implementation

Build Job wäre praktisch

### Scrum Retrospective