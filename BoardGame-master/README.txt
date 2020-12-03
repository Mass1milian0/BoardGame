Created by Francisco Guerra (francisco.guerra@ulpgc.es) for teaching.

This  eclipse project  duplicates  several directories  and  files  to 
facilitate its execution by means of two tools: GREENFOOT and ECLIPSE.

The main goal  of this duplication is to facilitate teaching using the 
advantages of each tool: the main advantage of GREENFOOT is simplicity 
of use,  and the main advantage  of ECLIPSE is to become familiar with 
Test Driven Development (TDD).

There are two run configurations: 
  - GreenfootScenarioMain (to run with ECLIPSE), and 
  - RunGreenfootFromEclipse (to run with GREENFOOT).

Eclipse does not know Greenfoot and therefore does not immediately detect 
the changes  Greenfoot makes.  So it’s  very important  to press  F5 when 
Greenfoot IDE ends and we go back to Eclipse IDE.


Board set cells color using an String matrix:

    /**
     * Set the color of all cells when cellColor has the same size
     * of world. When the size is different, it does nothing
     * 
     * @param borderColor is the color of border of all cells
     * @param cellColor is the matrix with the cells colors 
     */
    public void setBackground(Color borderColor, String[][] cellColor) 
    
Dorothy must travel the yellow cell path until it reaches the red  
cell and when it arrives the trumpets sound. But now Dorothy does  
not follow the yellow path since it only rotates 90 degrees when  
it is clicked and then moves to the next cell:

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            turn(90);
        }
        move(distance);
    }

DorothyTest contains some green tests for yellow path, for example:

    @Test
    public void testActFrom_0_0_To_1_0() throws Exception {
        // Given
        dorothy.setLocation(0, 0);

        // When
        dorothy.act();

        // Then
        assertEquals(1, dorothy.getX());
        assertEquals(0, dorothy.getY());
    }

    
But also, DorothyTest contains some red tests for yellow path, for example:

    @Test
    public void testActFrom_2_0_To_2_1() throws Exception {
        // Given
        dorothy.setLocation(2, 0);

        // When
        dorothy.act();   // turn 90
        dorothy.act();

        // Then
        assertEquals(2, dorothy.getX());
        assertEquals(1, dorothy.getY());
    }


The current exercise is to program GREEN step of TDD for Dorothy class, 
adding more tests to achieve Dorothy travels the yellow cell path 
until it reaches the red cell and when it arrives the trumpets sound,
using the next methods of Dorothy class:

    /**
     * Check if the color of cell(x,y) is yellow
     * 
     * @param x axis of cell
     * @param y axis of cell
     * @return true when cell(x,y) is yellow
     */
    public boolean isYellowCell(int x, int y)

    /**
     * Check if the color of cell(x,y) is red
     * 
     * @param x axis of cell
     * @param y axis of cell
     * @return true when cell(x,y) is red
     */
    public boolean isRedCell(int x, int y)

    /**
     * Set the color of cell(x,y) to black
     * 
     * @param x axis of cell
     * @param y axis of cell
     */
    public void setBlackCell(int x, int y)


These are the contents of its directories and files:

0.- There is  a hidden ".git" folder with the initial version  of this 
    scenario.  EGit is an Eclipse Team provider for Git.  This Eclipse 
    project includes Git initialization, so we can recover the initial 
    scenario if some mistake is made  that we are not able to recover.
    Some operations available to manage the scenario versions are:

       - Commit:  When you want to make a commit,  select Commit and 
         window will popup which asks for files to commit.

       - Push to Upstream: When you have made a commit, you can Push 
         those  changes to the server with this command. 

       - Fetch from Upstream:  When you want to update  your project 
         with  the latest commits someone  else have made to the Git 
         repository, you have to use this command. 
         
       - Pull:  If you have fetched  some changes  from the Upstream,  
         you  have to Pull these changes to Eclipses working project. 
         
       - Show in History:  This one shows  you the history  and made 
         changes in the project on its lifetime.

    You can get around  with these commands  in the world of Git and 
    Eclipse,  if you get some special needs,  I’m sure you will find 
    answers pretty fast with some Googling.

1.- Directory  "config" has  configuration  and data that ECLIPSE copies 
    into directory "bin" to use them during the execution of the program.
    
    - Subdirectories "images" and "sounds" have a link to the original
      images and sounds directories available in the GREENFOOT project.
      
    - File "defaultImages" links files available at config/images with
      Java  files  defined  in "src"  (in this way, the given image is 
      associated  by default with the class constructor if no image is 
      explicitly associated with the class).
                
    - File "standalone.properties"  has  the configuration  needed to run 
      the project with ECLIPSE (WorldClassName is the current application 
      world and must be located in the default package):
        
          project.name=ProjectName
          main.class=WorldClassName
             
      The RunGreenfootFromEclipse configuration (to run the program with
      the GREENFOOT  environment)  updates  this  file  with the current
      world and its project name  (there is bug in the "project renaming
      refactor"  feature  of  Eclipse  that  is automatically fixed when
      RunGreenfootFromEclipse is executed).

      There are two optional properties  which allow locking controls or
      hiding controls:

          scenario.lock=false
          scenario.hideControls=false
          
      When hideControls is set to true  (ie. controls are hidden), the
      application begins immediately when it is run; when set to false
      two buttons are added to start and stop its execution.


2.- Directory "resources" is usually empty and it is the folder that 
    should be used to store the data files that read or write the objects 
    that are executed in the Greenfoot scenario.


3.- Directory "src"  contains Java sources for ECLIPSE. It has a package
    named  "default package"  containing  all  the Java sources that the
    GREENFOOT tool need to handle. This package must have a World class.

    Programmers  may add  packages and move sources to such packages but
    they must  update accordingly the corresponding line located in file
    "defaultImages". For example:

          When the class is located in the default package:
              class.ClassName.image=NombreFicheroDeLaImagen
              
          When the class is located in PackageName:
              class.PackageName.ClassName.image=NombreFicheroDeLaImagen

    They  must  also  add  the name  of the new package to the GREENFOOT
    configuration  file  "defaultImages"  which  references  the  images 
    associated by default with each Java class.


4.- Directory "test" contains actors tests and it can be empty.  Here you 
    have how to write several kinds of tests by junit4.  Notice that Java  
    sources that you see in comments  are assumed  to be available in our  
    project (in the src directory), and they are needed for these tests.
 

       import static org.junit.Assert.*;

       import org.junit.Before;
       import org.junit.Test;
       import org.junit.runner.RunWith;

       import greenfoot.*;
       import greenfoot.junitUtils.*;
       import greenfoot.junitUtils.runner.GreenfootRunner;

       @RunWith(GreenfootRunner.class)
       public class ExampleActorTest {

           private World world;

           @Before
           public void setUp() throws Exception {
               world = WorldCreator.getWorld(400, 300, 1);
           }

           /**
            * Example that checks the position in the world
            *
            *    public class ExampleActor extends greenfoot.Actor{
            *    }
            */
           @Test 
           public void testMethodNameThatIsTested() throws Exception { 
               ExampleActor exampleActor = new ExampleActor();
               world.addObject(exampleActor, 1, 4);
               assertEquals(1, exampleActor.getX());
               assertEquals(4, exampleActor.getY());
           }

           /**
            * Example that checks a new method in a derived world 
            *    
            *    public class ExampleWorld extends greenfoot.World {
            *        public ExampleWorld(){
            *            super(300,200,1);
            *        }
            *        public ExampleActor addObjectAt(int x, int y){
            *            ExampleActor exampleActor = new ExampleActor();
            *            addObject(exampleActor, x, y);
            *            return exampleActor;
            *        }
            *    }

            *    public class ExampleActor extends greenfoot.Actor{
            *    }
            */
           @Test 
           public void testCreateObjetsInExampleWorld() throws Exception {
               ExampleWorld exampleWorld
                 = WorldCreator.getWorld(ExampleWorld.class);
               ExampleActor exampleActor = exampleWorld.addObjectAt(20, 30);
               assertEquals(20, exampleActor.getX());
               assertEquals(30, exampleActor.getY());
           }

           /**
            * Example that checks the world behavior of ExampleActor
            * when its act() method is invoked:
            * 
            *    public class ExampleActor extends greenfoot.Actor{
            *        @Override
            *        public void act() 
            *        {
            *             move(6);
            *        }
            *    }
            */
           @Test
           public void testAct() throws Exception {
               ExampleActor exampleActor = new ExampleActor();
               world.addObject(exampleActor, 1, 1);
               WorldCreator.runOnce();
              
               assertEquals(7, exampleActor.getX());
               assertEquals(1, exampleActor.getY());
           }

           /**
            * Example that checks the world behavior of ExampleActor
            * when its act() method is invoked:
            * 
            *    public class ExampleActor extends greenfoot.Actor{
            *        @Override
            *        public void act() 
            *        {
            *             move(Greenfoot.getRandomNumber(10));
            *        }
            *    }
            */
           @Test
           public void testAct() throws Exception {
               ExampleActor exampleActor = new ExampleActor();
               world.addObject(exampleActor, 1, 1);
               Random.set(3);
               WorldCreator.runOnce();
              
               assertEquals(4, exampleActor.getX());
               assertEquals(1, exampleActor.getY());
           }
           @Test
           public void testActRandomWithCallerClassName() throws Exception {
               ExampleActor exampleActor = new ExampleActor();
               world.addObject(exampleActor, 1, 1);
               Random.set(6, exampleActor.getClass());        
               exampleActor.act();
               assertEquals(7, exampleActor.getX());
               assertEquals(1, exampleActor.getY());
           }
           @Test
           public void testRandomWithOthersGetRandomNumber() throws Exception {
               ExampleActor exampleActor = new ExampleActor();
               world.addObject(exampleActor, 1, 1);
               Random.set(6, exampleActor.getClass());  
               Greenfoot.getRandomNumber(10);
               exampleActor.act();
               assertEquals(7, exampleActor.getX());
               assertEquals(1, exampleActor.getY());
           }

           /**
            * Example that checks the world behavior of ExampleActor
            * when the mouse is clicked or when the right key is
            * pressed in the keyboard.
            * 
            *    public class ExampleActor extends greenfoot.Actor{
            *        @Override
            *        public void act() 
            *        {
            *             move(2);
            *             if (Greenfoot.isKeyDown("right")){
            *                 move(4);
            *             }
            *             if (Greenfoot.mouseClicked(this)){
            *                 move(6);
            *             }
            *        }
            *    }
            */
           @Test // There is not any event
           public void testWithoutEvens() throws Exception {
               ExampleActor exampleActor = new ExampleActor();
               world.addObject(exampleActor, 2, 3);
               WorldCreator.runOnce();
              
               assertEquals(3, exampleActor.getX());
               assertEquals(1, exampleActor.getY());
           }
           @Test // There is a keyboard event
           public void testKeyboardTyped() throws Exception {
               ExampleActor exampleActor = new ExampleActor();
               world.addObject(exampleActor, 2, 3);
               EventDispatch.keyTyped("right");
               WorldCreator.runOnce();
              
               assertEquals(7, exampleActor.getX());
               assertEquals(1, exampleActor.getY());
           }
           @Test // There is a mouse event
           public void testMouseClicked() throws Exception {
               ExampleActor exampleActor = new ExampleActor();
               world.addObject(exampleActor, 2, 3);
               EventDispatch.mouseClicked(2, 3);
               WorldCreator.runOnce();
              
               assertEquals(9, exampleActor.getX());
               assertEquals(1, exampleActor.getY());
           }
           @Test // There is a mouse event with cell size > 1 
           public void testAct_rigthB() throws Exception {
               World world = WorldCreator.getWorld(15, 15, 20);
               ExampleActor exampleActor = new ExampleActor();
               world.addObject(exampleActor, 2, 3);
               EventDispatch.mouseClicked(2, 3);
               WorldCreator.runOnce();

               assertEquals(9, exampleActor.getX());
               assertEquals(1, exampleActor.getY());
           }
           @Test // There are mouse and keyboard events
           public void testMouseClickedAndKeyboardTyped() throws Exception {
               ExampleActor exampleActor = new ExampleActor();
               world.addObject(exampleActor, 2, 3);
               EventDispatch.mouseClicked(2, 3);
               EventDispatch.keyTyped("right");
               WorldCreator.runOnce();
              
               assertEquals(13, exampleActor.getX());
               assertEquals(1, exampleActor.getY());
           }

           /**
            * Example that checks a behavior in the world
            * with keyboard input, applying to ExampleActor
            * object with next act behavior:
            * 
            *    public class ExampleActor extends greenfoot.Actor{
            *       @Override
            *       public void act() 
            *       {
            *           if (Greenfoot.isKeyDown("g")){
            *               this.setLocation(10, 20);
            *           }
            *           if (!Greenfoot.isKeyDown("g")){
            *               this.setLocation(100, 20);
            *           }
            *        }
            *    }
            */
           @Test 
           public void testType_g() throws Exception {
               ExampleActor exampleActor = new ExampleActor();
               world.addObject(exampleActor, 1, 1);
               EventDispatch.keyTyped("g");
               exampleActor.act();
               assertEquals(100, exampleActor.getX());
               assertEquals(20, exampleActor.getY());
           }
           @Test 
           public void testPress_g() throws Exception {
               ExampleActor exampleActor = new ExampleActor();
               world.addObject(exampleActor, 1, 1);
               EventDispatch.keyPressed("g");
               exampleActor.act();
               assertEquals(10, exampleActor.getX());
               assertEquals(20, exampleActor.getY());
           }
           @Test 
           public void testRelease_g() throws Exception {
               ExampleActor exampleActor = new ExampleActor();
               world.addObject(exampleActor, 1, 1);
               EventDispatch.keyPressed("g");
               EventDispatch.keyReleased("g");
               exampleActor.act();
               assertEquals(100, exampleActor.getX());
               assertEquals(20, exampleActor.getY());
           }

           /**
            * Example that checks a behavior in the world
            * with input string by ask method, applying to 
            * ExampleActor object with next act behavior:
            * 
            *    public class ExampleActor extends greenfoot.Actor{
            *       private String ask;
            *
            *       @Override
            *       public void act(){
            *           if (Greenfoot.mouseClicked(this)){
            *               ask = Greenfoot.ask("");
            *           }
            *       }
            *
            *       public String getAsk(){
            *           return ask;
            *       }
            *    }
            */
            @Test 
            public void testAskOne() throws Exception {
                ExampleActorAsk exampleActorAsk = new ExampleActorAsk();
                world.addObject(exampleActorAsk, 1, 1);
                EventDispatch.mouseClicked(1,1);
                Ask.set("One");
                WorldCreator.runOnce();
               
                assertEquals("One", exampleActorAsk.getAsk());
            }
            @Test 
            public void testAskTwo() throws Exception {
                ExampleActorAsk exampleActorAsk = new ExampleActorAsk();
                world.addObject(exampleActorAsk, 1, 1);
                EventDispatch.mouseClicked(1,1);
                Ask.set("Two");
                WorldCreator.runOnce();
        
                assertEquals("Two", exampleActorAsk.getAsk());
            }

           /**
            * Example that checks the sound played
            *
            *    public class ExampleActor extends greenfoot.Actor{
            *         @Override
            *         public void act(){
            *             Greenfoot.playSound("au.wav");
            *         }
            *    }
            */
            @Test 
            public void testSoundPlayedAct() throws Exception {
                ExampleActor exampleActor = new ExampleActor();
                world.addObject(exampleActor, 10, 10);
                exampleActor.act();
                assertEquals("au.wav", SoundPlayed.get());
            }
            @Test 
            public void testSoundPlayedRunOnce() throws Exception {
                world.addObject(new ExampleActor(), 10, 10);
                WorldCreator.runOnce();
                assertEquals("au.wav", SoundPlayed.get());
            }
       }


--------------------------------------------------------

    The scenario empty-greenfoot-project must be renamed and after
    must be added world class by RunGreenfootFromEclipse

--------------------------------------------------------
