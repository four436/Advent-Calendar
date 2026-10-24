import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.Serial;

public class App extends JFrame {
    int currentDatePanel;
    String Romanian[] = {"Decembrie", "Luni", "Marti", "Miercuri", "JOI", "Vineri", "Sâbata", "Duminica", "Română", "Înapoi"};
    String RomanianMessage[] ={
        "<html><div style='width:300px;'>„Iarna îmblânzeste omul si fiara.”<br><div style='text-align:right;'>(William Shakespeare)</div></div></html>",
        "<html><div style='width:300px;'>„Pentru a putea întelege frumusetea unui fulg de zapada, trebuie sa accepti frigul.”<br><div style='text-align:right;'>(Aristotel)</div></div></html>",
        "<html><div style='width:300px;'>„Niciun foc nu se poate compara cu stralucirea unei zile de iarna.”<br><div style='text-align:right;'>(Henry David Thoreau)</div></div></html>",
        "<html><div style='width:300px;'>„Auzi ploaia cum cade, dar zapada nu. Durerea cruda este zgomotoasa, cea acceptata este tacuta.”<br><div style='text-align:right;'>(Berthold Auerbach)</div></div></html>",
        "<html><div style='width:300px;'>„Iarna este o perioada de odihna și pregatire.”<br><div style='text-align:right;'>(Paul Theroux)</div></div></html>",
        "<html><div style='width:300px;'>„Gheata neteda este un paradis pentru cei care stiu să danseze bine.”<br><div style='text-align:right;'>(Friedrich Nietzsche)</div></div></html>",
        "<html><div style='width:300px;'>„În adâncul iernii am descoperit, în cele din urma, că în mine zace o vara de neînvins.”<br><div style='text-align:right;'>(Albert Camus)</div></div></html>",
        "<html><div style='width:300px;'>„Politetea este ca zapada – înfrumuseteaza tot ce atinge.”<br><div style='text-align:right;'>(Kahlil Gibran)</div></div></html>",
        "<html><div style='width:300px;'>„Chiar și cele mai puternice furtuni de zapada încep cu un singur fulg de nea.”<br><div style='text-align:right;'>(Sara Raasch)</div></div></html>",
        "<html><div style='width:300px;'>„Iarna este perioada în care este prea frig pentru a face ceea ce vara este prea cald.”<br><div style='text-align:right;'>(Mark Twain)</div></div></html>",
        "<html><div style='width:300px;'>„Gloria poate fi comparata cu perele de iarna, care cresc vara, dar sunt savurate iarna.”<br><div style='text-align:right;'>(Arthur Schopenhauer)</div></div></html>",
        "<html><div style='width:300px;'>„Minciuna este ca un bulgare de zapada: cu cât îl rostogolesti mai mult, cu atât devine mai mare.”<br><div style='text-align:right;'>(Martin Luther)</div></div></html>",
        "<html><div style='width:300px;'>„Este viata cristalului, arhitectul fulgului, focul înghetului, sufletul razei de soare. Aceast aer proaspat de iarna este plin de ele.”<br><div style='text-align:right;'>(John Burroughs)</div></div></html>",
        "<html><div style='width:300px;'>„În spatele fiecarei ierni se ascunde o primavara tremurânda si în spatele fiecărei nopti se ascunde o dimineata zâmbitoare.”<br><div style='text-align:right;'>(Kahlil Gibran)</div></div></html>",
        "<html><div style='width:300px;'>„Dragostea este caldura în care gheața inimii se topeste.”<br><div style='text-align:right;'>(Jeremias Gotthelf)</div></div></html>",
        "<html><div style='width:300px;'>„Niciun fulg de zapada din avalansa nu se va simti vreodata responsabil.”<br><div style='text-align:right;'>(Stanislaw Jerzy Lec)</div></div></html>",
        "<html><div style='width:300px;'>„Nu poti avea prea multa iarna iarna.”<br><div style='text-align:right;'>(Robert Frost)</div></div></html>",
        "<html><div style='width:300px;'>„Râsul este soarele care alunga iarna de pe chipul uman.”<br><div style='text-align:right;'>(Victor Hugo)</div></div></html>",
        "<html><div style='width:300px;'>„Citesc pâna târziu în noapte, iar iarna plec spre sud.”<br><div style='text-align:right;'>(T.S. Eliot)</div></div></html>",
        "<html><div style='width:300px;'>„Caldura, mai multa caldura. Pentru ca murim de frig, nu de întuneric. Nu noaptea ucide, ci înghetul.”<br><div style='text-align:right;'>(Miguel de Unamuno)</div></div></html>",
        "<html><div style='width:300px;'>„Un cuvânt prietenos poate încalzi trei luni de iarna.”<br><div style='text-align:right;'>(Proverb japonez)</div></div></html>",
        "<html><div style='width:300px;'>„Inima noastra devine putin mai tare înainte sa se topeasca, la fel ca zapada.”<br><div style='text-align:right;'>(Wolfgang Menzel)</div></div></html>",
        "<html><div style='width:300px;'>„Un sfat bun este ca zapada. Cu cât cade mai ușor, cu atât ramâne mai mult timp si patrunde mai adânc.”<br><div style='text-align:right;'>(Jeremiah Seed)</div></div></html>",
        "<html><div style='width:300px;'>„Zapada care se modeleaza usor se topeste repede.”<br><div style='text-align:right;'>(Jean Paul)</div></div></html>",
        "<html><div style='width:300px;'>„Putin soare si zapada se topeste. Putina caldura si gheata se sparge. Putina bunatate si noi, oamenii, ne dezghetam.”<br><div style='text-align:right;'>(Petrus Ceelen)</div></div></html>",
        "<html><div style='width:300px;'>„Fara frigul iernii, nu ar exista caldura primaverii.”<br><div style='text-align:right;'>(Ho Chi Minh)</div></div></html>",
        "<html><div style='width:300px;'>„Unele gânduri se asaza în inimile noastre precum zapada care cade usor.”<br><div style='text-align:right;'>(Ernst R. Hauschka)</div></div></html>",
        "<html><div style='width:300px;'>„Bate, bate, vânt de iarna. Nu esti la fel de crud ca nerecunostinta oamenilor.”<br><div style='text-align:right;'>(William Shakespeare)</div></div></html>",
        "<html><div style='width:300px;'>„Chiar si cel mai frumos om de zapada devine o balta primavara.”<br><div style='text-align:right;'>(Hans Kasper)</div></div></html>",
        "<html><div style='width:300px;'>„Florile primaverii sunt visele iernii.”<br><div style='text-align:right;'>(Kahlil Gibran)</div></div></html>",
        "<html><div style='width:300px;'>„Iarna este timpul pentru confort, pentru mâncare buna si caldura, pentru atingerea unei mâini prietenoase si pentru o discutie lânga foc: este timpul pentru acasa.”<br><div style='text-align:right;'>(Edith Sitwell)</div></div></html>"

    };
    String Deutchland[] = {"Dezember " , "Montag" , "Dienstag" , "Mittwoch" , "Donnerstag" , "Freitag" , "Samstag" , "Sonntag" , "Deutsch", "zurück"};
    String DeautschMessage[] ={
    "<html><div style='width:300px;'>„Der Winter zähmt Mensch und Tier.“<br><div style='text-align:right;'>(William Shakespeare)</div></div></html>",
    "<html><div style='width:300px;'>„Um die Schönheit einer Schneeflocke erfassen zu können, muss man die Kälte in Kauf nehmen.“<br><div style='text-align:right;'>(Aristoteles)</div></div></html>",
    "<html><div style='width:300px;'>„Kein Feuer kann sich mit dem Sonnenschein eines Wintertages messen.“<br><div style='text-align:right;'>(Henry David Thoreau)</div></div></html>",
    "<html><div style='width:300px;'>„Den Regen hört man fallen, den Schnee nicht. Der herbe Schmerz ist noch laut, der gefaßte ist still.“<br><div style='text-align:right;'>(Berthold Auerbach)</div></div></html>",
    "<html><div style='width:300px;'>„Der Winter ist eine Zeit der Erholung und der Vorbereitung.“<br><div style='text-align:right;'>(Paul Theroux)</div></div></html>",
    "<html><div style='width:300px;'>„Glattes Eis, ein Paradies für den, der gut zu tanzen weiß.“<br><div style='text-align:right;'>(Friedrich Nietzsche)</div></div></html>",
    "<html><div style='width:300px;'>„In den Tiefen des Winters erfuhr ich schließlich, dass in mir ein unbesiegbarer Sommer liegt.“<br><div style='text-align:right;'>(Albert Camus)</div></div></html>",
    "<html><div style='width:300px;'>„Höflichkeit ist wie Schnee – sie verschönert alles, was sie berührt.“<br><div style='text-align:right;'>(Kahlil Gibran)</div></div></html>",
    "<html><div style='width:300px;'>„Selbst die stärksten Schneestürme beginnen mit einer einzigen Schneeflocke.“<br><div style='text-align:right;'>(Sara Raasch)</div></div></html>",
    "<html><div style='width:300px;'>„Winter ist die Zeit, in der es zu kalt ist, das zu tun, wofür es im Sommer zu heiß ist.“<br><div style='text-align:right;'>(Mark Twain)</div></div></html>",
    "<html><div style='width:300px;'>„Den Ruhm kann man mit Winterbirnen vergleichen, die im Sommer wachsen, aber im Winter genossen werden.“<br><div style='text-align:right;'>(Arthur Schopenhauer)</div></div></html>",
    "<html><div style='width:300px;'>„Die Lüge ist wie ein Schneeball: Je länger man ihn wälzt, desto größer wird er.“<br><div style='text-align:right;'>(Martin Luther)</div></div></html>",
    "<html><div style='width:300px;'>„Es ist das Leben des Kristalls, der Architekt der Flocke, das Feuer des Frosts, die Seele des Sonnenstrahls. Diese frische Winterluft ist voll davon.“<br><div style='text-align:right;'>(John Burroughs)</div></div></html>",
    "<html><div style='width:300px;'>„Hinter jedem Winter steckt ein zitternder Frühling und hinter dem Schleier jeder Nacht verbirgt sich ein lächelnder Morgen.“<br><div style='text-align:right;'>(Khalil Gibran)</div></div></html>",
    "<html><div style='width:300px;'>„Die Liebe ist die Wärme, in welcher das Eis des Herzens schmilzt.“<br><div style='text-align:right;'>(Jeremias Gotthelf)</div></div></html>",
    "<html><div style='width:300px;'>„Keine Schneeflocke in der Lawine wird sich je verantwortlich fühlen.“<br><div style='text-align:right;'>(Stanislaw Jerzy Lec)</div></div></html>",
    "<html><div style='width:300px;'>„Man kann im Winter nicht zu viel Winter bekommen.“<br><div style='text-align:right;'>(Robert Frost)</div></div></html>",
    "<html><div style='width:300px;'>„Das Lachen ist die Sonne, die aus dem menschlichen Antlitz den Winter vertreibt.“<br><div style='text-align:right;'>(Victor Hugo)</div></div></html>",
    "<html><div style='width:300px;'>„Ich lese, tief in die Nacht, und im Winter geh‘ ich in den Süden.“<br><div style='text-align:right;'>(T.S. Eliot)</div></div></html>",
    "<html><div style='width:300px;'>„Wärme, Wärme, mehr Wärme. Denn wir sterben an der Kälte und nicht an der Dunkelheit. Nicht die Nacht tötet, sondern der Frost.“<br><div style='text-align:right;'>(Miguel de Unamuno)</div></div></html>",
    "<html><div style='width:300px;'>„Ein freundliches Wort kann drei Wintermonate wärmen.“<br><div style='text-align:right;'>(Japanisches Sprichwort)</div></div></html>",
    "<html><div style='width:300px;'>„Unser Herz verhärtet sich gern ein wenig, eh’ es schmilzt, gleich dem Schnee.“<br><div style='text-align:right;'>(Wolfgang Menzel)</div></div></html>",
    "<html><div style='width:300px;'>„Ein guter Rat ist wie Schnee. Je sanfter er fällt, desto länger bleibt er liegen und um so tiefer dringt er ein.“<br><div style='text-align:right;'>(Jeremiah Seed)</div></div></html>",
    "<html><div style='width:300px;'>„Schnee, der sich leicht ballen läßt, schmilzt bald.“<br><div style='text-align:right;'>(Jean Paul)</div></div></html>",
    "<html><div style='width:300px;'>„Ein wenig Sonne, und der Schnee schmilzt. Ein wenig Wärme, und das Eis bricht. Ein wenig Güte, und wir Menschen tauen auf.“<br><div style='text-align:right;'>(Petrus Ceelen)</div></div></html>",
    "<html><div style='width:300px;'>„Ohne die Kälte des Winters gäbe es die Wärme des Frühlings nicht.“<br><div style='text-align:right;'>(Ho Chi Minh)</div></div></html>",
    "<html><div style='width:300px;'>„Manche Gedanken setzen sich in unserem Herzen nieder wie der leise fallende Schnee.“<br><div style='text-align:right;'>(Ernst R. Hauschka)</div></div></html>",
    "<html><div style='width:300px;'>„Schlag, Schlag, du Winterwind. Du bist nicht so unfreundlich wie die Undankbarkeit des Menschen.“<br><div style='text-align:right;'>(William Shakespeare)</div></div></html>",
    "<html><div style='width:300px;'>„Auch der schönste Schneemann ist im Frühling eine Pfütze.“<br><div style='text-align:right;'>(Hans Kasper)</div></div></html>",
    "<html><div style='width:300px;'>„Die Blumen des Frühlings sind die Träume des Winters.“<br><div style='text-align:right;'>(Khalil Gibran)</div></div></html>",
    "<html><div style='width:300px;'>„Der Winter ist die Zeit für Komfort, gutes Essen und Wärme, für das Ergreifen einer freundlichen Hand und für ein Gespräch am Feuer: es ist die Zeit für Zuhause.”<br><div style='text-align:right;'>(Edith Sitwell)</div></div></html>"
    };
    String language = "DEU";
    String textexro = "TEXT RO";
    String textexdeu = "TEXT DEU";
    JPanel motherPanel = new JPanel(new GridLayout(1,1));
    JPanel MainPanel = new JPanel();
    JPanel HeaderPanel = new JPanel();
    JPanel CenterPanel = new JPanel();
    JPanel LanguagePanel = new JPanel();
    JPanel[] MessagesPanel = new JPanel[31];
    JPanel LanguageMessageButtonPanel = new JPanel();
    JPanel BackButtonPanel = new JPanel();
    JButton[] Date = new JButton[31]; 
    JButton LanguageButton = new JButton("DEU");
    JButton LanguageMessageButton = new JButton("DEU");
    JButton BackButton = new JButton(Deutchland[9]);
    JLabel[] Day = new JLabel[7];
    JLabel[] EmptyLabel = new JLabel[6];
    JLabel Month = new JLabel(Deutchland[0]);
    JLabel[] Messages = new JLabel[31];
    JLabel backgeoundLabel = new JLabel(new ImageIcon(getClass().getResource("/resources/icegif-1341.gif")));
    public class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e.getActionCommand());
            int date = Integer.valueOf(e.getActionCommand());
            currentDatePanel = date-1;
            motherPanel.remove(MainPanel);
            motherPanel.repaint();
            motherPanel.revalidate();
            motherPanel.add(MessagesPanel[date-1]);
            if(language == "RO"){
                Messages[date-1].setText(RomanianMessage[date-1]);
            }else{
                Messages[date-1].setText(DeautschMessage[date-1]);
            }
            Messages[date-1].setHorizontalAlignment(JLabel.CENTER);
            Messages[date-1].setVerticalAlignment(JLabel.CENTER);
            MessagesPanel[date-1].add(LanguageMessageButtonPanel, BorderLayout.SOUTH);
            MessagesPanel[date-1].add(BackButtonPanel, BorderLayout.NORTH);
            MessagesPanel[date-1].repaint();
            MessagesPanel[date-1].revalidate();
            motherPanel.repaint();
            motherPanel.revalidate();
        }

    }

    public class LanguageMessageButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            changeLanguage(e.getActionCommand());
            if(e.getActionCommand().equals("RO")){
                language = "DEU";
                BackButton.setText(Deutchland[9]);
                LanguageButton.setText("DEU");
                LanguageMessageButton.setText("DEU");
                Messages[currentDatePanel].setText(DeautschMessage[currentDatePanel]);
            }else{
                language = "RO";
                BackButton.setText(Romanian[9]);
                LanguageButton.setText("RO");
                LanguageMessageButton.setText("RO");
                Messages[currentDatePanel].setText(RomanianMessage[currentDatePanel]);

            }
        }
        
    }

    public class BackButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            motherPanel.remove(MessagesPanel[currentDatePanel]);
            motherPanel.repaint();
            motherPanel.revalidate();
            motherPanel.add(MainPanel);
            motherPanel.repaint();
            motherPanel.revalidate();
        }
        
    }

    public class LanguageButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            changeLanguage(e.getActionCommand());
            if(e.getActionCommand() == "RO"){
                BackButton.setText(Deutchland[9]);
                LanguageButton.setText("DEU");
                LanguageMessageButton.setText("DEU");
                language = "DEU";
            }else{
                BackButton.setText(Romanian[9]);
                LanguageButton.setText("RO");
                LanguageMessageButton.setText("RO");
                language = "RO";
            }
        }
        
    }
    
    public void changeLanguage(String lang){
    
        if(lang == "DEU"){
            Month.setText(Romanian[0]);
            for(int i = 0; i < 7; i++){
                Day[i].setText(Romanian[i+1]);
            }

        }else{
            Month.setText(Deutchland[0]);
            for(int i = 0; i < 7; i++){
                Day[i].setText(Deutchland[i+1]);
            }
        }

    }

    public void initMessagesPanel(){
        for(int i = 0; i < 31; i++){
            Messages[i] = new JLabel();
            Messages[i].setFont(new Font("Cooper Black", ABORT, 20));
        }
        for(int i = 0; i < 31 ; i++){
            MessagesPanel[i] = new JPanel(new BorderLayout());
            MessagesPanel[i].add(Messages[i], BorderLayout.CENTER);
        }
    }

    private static void setTransparent(JComponent component) {
        component.setOpaque(false);
        component.setBackground(new Color(0,0,0,128));  // fully transparent
    }

    public App(){
        setTitle("Dezember-Kalender");
        ImageIcon icon = new ImageIcon(getClass().getResource("/resources/5311.png"));
        setIconImage(icon.getImage());
        setSize (1024, 619);
        setResizable(false);
        setVisible (true);
        setLocation (0, 0);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1 , 1));
        backgeoundLabel.setLayout(new BorderLayout());
        MainPanel.setOpaque(false);
        add(backgeoundLabel);
        revalidate();
        repaint();
        backgeoundLabel.add(motherPanel, BorderLayout.CENTER);
        motherPanel.add(MainPanel);
        initMessagesPanel();
        LanguageMessageButton.addActionListener(new LanguageMessageButtonListener());
        LanguageMessageButtonPanel.add(LanguageMessageButton);
        BackButton.addActionListener(new BackButtonListener());
        BackButtonPanel.add(BackButton);

        MainPanel.setLayout(new BorderLayout());
        MainPanel.add(HeaderPanel, BorderLayout.NORTH);
        MainPanel.add(CenterPanel,BorderLayout.CENTER);
        MainPanel.add(LanguagePanel, BorderLayout.SOUTH);
        Month.setFont(new Font("Cooper Black", ABORT, 20));
        HeaderPanel.add(Month);
        CenterPanel.setLayout(new GridLayout(7,7));
        LanguageButton.addActionListener(new LanguageButtonListener());
        LanguagePanel.add(LanguageButton);

        Day[0] = new JLabel(Deutchland[1]);
        Day[0].setBorder(BorderFactory.createMatteBorder(2, 2, 2, 1, Color.BLACK));
        Day[0].setHorizontalAlignment(SwingConstants.CENTER);
        CenterPanel.add(Day[0]);
        for(int i = 1; i < 6; i++){
            Day[i] = new JLabel(Deutchland[i+1]);
            Day[i].setHorizontalAlignment(SwingConstants.CENTER);
            Day[i].setBorder(BorderFactory.createMatteBorder(2, 1, 2, 1, Color.BLACK));
            
            CenterPanel.add(Day[i]);
        }
        Day[6] = new JLabel(Deutchland[7]);
        Day[6].setBorder(BorderFactory.createMatteBorder(2, 1, 2, 2, Color.BLACK));
        Day[6].setHorizontalAlignment(SwingConstants.CENTER);
        CenterPanel.add(Day[6]);
        for(int i = 0; i < 6; i++){
            EmptyLabel[i] = new JLabel();
            CenterPanel.add(EmptyLabel[i]);
        }
        for(int i = 0; i < 31; i++){
            Date[i]= new JButton(String.valueOf(i+1));
            Date[i].addActionListener(new ButtonListener());
            CenterPanel.add(Date[i]);
        }
        repaint();
        revalidate();

        setTransparent(motherPanel);
        setTransparent(MainPanel);
        setTransparent(HeaderPanel);
        setTransparent(CenterPanel);
        setTransparent(LanguagePanel);
        setTransparent(LanguageMessageButtonPanel);
        setTransparent(BackButtonPanel);
        set50transparent(LanguageButton);
        set50transparent(LanguageMessageButton);
        set50transparent(BackButton);
        set50transparent(Month);
        for(int i = 0; i < 31; i++){
            setTransparent(MessagesPanel[i]);
            set50transparent(Date[i]);
            set50transparent(Messages[i]);
        }

        for(int i = 0; i < 7; i++){
            set50transparent(Day[i]);
        }

        for(int i = 0; i < 6; i++){
            setTransparent(EmptyLabel [i]);
        }

        try {
            // Specify the path to your audio file
            

            // Create an audio input stream
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(getClass().getResource("/resources/Leise-rieselt-der-Schnee.wav"));

            // Get a sound clip resource
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            // Loop the audio
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            // Start playing
            clip.start();
            
        } catch (UnsupportedAudioFileException e) {
            System.out.println("The audio format is not supported.");
        } catch (IOException e) {
            System.out.println("Error reading the audio file.");
        } catch (LineUnavailableException e) {
            System.out.println("Audio line for playing the audio is unavailable.");
        }
        
    }

    public void set50transparent(JComponent comp){
        comp.setOpaque(true);
        comp.setBackground(new Color(180, 230, 255, 128));
    }
    public static void main(String[] args) throws Exception {
        JFrame window = new App();
        
    }
}
