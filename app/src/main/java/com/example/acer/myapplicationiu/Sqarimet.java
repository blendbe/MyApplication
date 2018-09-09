package com.example.acer.myapplicationiu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class Sqarimet extends AppCompatActivity {
    TextView textView, textView1, textView2, textView3, textView4, textView5, textView6;
    ArrayList<String> lista;
    Bundle bundle;
    String sem;
    String exclude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqarimet2);
        bundle = new Bundle();
        bundle = getIntent().getExtras();
        sem = bundle.getString("semundja");
        textView = findViewById(R.id.tekstgrip);
        textView1 = findViewById(R.id.tekstgrip1);
        textView2 = findViewById(R.id.tekstgrip2);
        textView3 = findViewById(R.id.tekstgrip3);
        textView4 = findViewById(R.id.tekstgrip4);
        textView5 = findViewById(R.id.tekstgrip5);
        textView6 = findViewById(R.id.tekstgrip6);
        if (sem.contains("10%"))
            exclude = sem.replace("10%", "");
        else if (sem.contains("20%"))
            exclude = sem.replace("20%", "");
        else if (sem.contains("30%"))
            exclude = sem.replace("30%", "");
        else if (sem.contains("40%"))
            exclude = sem.replace("40%", "");
        else if (sem.contains("50%"))
            exclude = sem.replace("50%", "");
        else
            exclude = sem.replace("60%", "");
        textView.setText(exclude);
            if (sem.contains("Grip sezonal")) {
                textView.setText("Gripi sezonal");
                textView1.setText("Gripi është një sëmundje ngjitëse e frymëmarrjes e shkaktuar nga viruset e" +
                        " influencës që infektojnë hundën, fytin dhe ndonjëherë edhe mushkëritë. " +
                        "Mund të shkaktojë sëmundje të lehta dhe të rënda dhe në disa raste mund të çojë në vdekje. " +
                        "Mënyra më e mirë për të parandaluar gripin është marrja e vaksinës së gripit çdo vit." +
                        "");
                textView2.setText("Njerëzit që kanë gripin shpesh ndiejnë disa ose të gjitha këto shenja dhe simptoma që zakonisht fillojnë papritmas, jo gradualisht:\n" +
                        "Ethe * ose ndjenja e temperaturës / dridhura\n" +
                        "kollë\n" +
                        "Dhimbje të fytit\n" +
                        "Hundë e zhurmshme ose e zënë\n" +
                        "Musku ose dhimbje të trupit\n" +
                        "Dhimbje koke\n" +
                        "Lodhje (shumë lodhje)\n" +
                        "Disa njerëz mund të kenë vjellje dhe diarre, edhe pse kjo është më e zakonshme tek fëmijët e vegjël sesa tek të rriturit.");
                textView3.setText("Diagnostifikohet nga mjeku internist dhe mjeku i pergjithshem. Diagnostifimi dhe trajtimi behet ne baze te simptomave" +
                        "por mjeku mund te udhezoje realizimin e testeve urinore dhe te gjakut per te konkluduar mbi komplikimet e mundshme.");
                textView4.setText("Gripi zakonisht kalohet brenda dy javeve pushimi. Pirja e antihistaminozeve dhe e ilaceve kunder dhimbjes, pirja" +
                        "e ujit deri ne 2L ne dite mund te ndihmoje ne permiresimin e simptomave. Zakonisht gripi keqesohet kur personi nuk pushon" +
                        "mjaftueshem, kur pi duhan ose nuk pi mjaftueshem lengje.");
                textView5.setText("Mjeku i pergjithshem, Mjeku familjar, Internisti");
                textView6.setText("Paracetamol, Iboprufen, Tylenol, Aspirin");

            }
            if (sem.contains("Depresion"))
            {
                textView.setText("Depresioni");
                textView1.setText("Depresioni (çrregullimi i madh depresiv) është një sëmundje e zakonshme dhe serioze mjekësore që ndikon " +
                        "negativisht në mënyrën se si ndjeheni, mënyrën se si mendoni dhe si veproni. Për fat të mirë, ajo është gjithashtu e " +
                        "shërueshme. Depresioni shkakton ndjenja trishtimi dhe / ose humbjeje të interesit në aktivitetet që gëzonin dikur. " +
                        "Kjo mund të çojë në një" +
                                " sërë problemesh emocionale dhe fizike dhe mund të ulë aftësinë e një personi për të funksionuar në punë dhe në shtëpi.");
                textView2.setText("Simptomat e depresionit mund të ndryshojnë nga të lehta në të rënda dhe mund të përfshijnë:\n" +
                        "\n" +
                        "Ndjenja e trishtimit ose të paturit e një gjendjeje depresive\n" +
                        "Humbja e interesit ose kënaqësia në aktivitetet e gëzuara dikur\n" +
                        "Ndryshimet në oreksin - humbje peshe ose fitim të palidhur me dietë\n" +
                        "Probleme duke fjetur ose duke fjetur shumë\n" +
                        "Humbja e energjisë ose lodhja në rritje\n" +
                        "Rritja e aktivitetit fizik të pandikuar (p.sh., shtrëngimi i dorës ose ritmi) ose ngadalësimi i lëvizjeve dhe fjalëve (veprime të vëzhgueshme nga të tjerët)\n" +
                        "Ndjenjë të pavlefshme ose fajtore\n" +
                        "Vështirësia e të menduarit, përqëndrimi ose marrja e vendimeve\n" +
                        "Mendime për vdekje ose vetëvrasje\n" +
                        "Simptomat duhet të zgjasin të paktën dy javë për një diagnozë të depresionit.\n" +
                        "\n" +
                        "Gjithashtu, kushtet mjekësore (p.sh., problemet e tiroides, tumori i trurit ose mungesa e vitaminave) mund të imitojnë simptomat e depresionit kështu që është e rëndësishme të përjashtohen shkaqet e përgjithshme mjekësore.\n" +
                        "\n" +
                        "Depresioni ndikon një vlerësim në 15 të rritur (6.7%) në çdo vit të caktuar. Dhe një në gjashtë vetë (16.6%) do të përjetojnë depresion në një kohë në jetën e tyre. Depresioni mund të godasë në çdo kohë, por mesatarisht, shfaqet së pari gjatë adoleshencës së vonë deri në mesin e viteve të 20-ta. Gratë kanë më shumë gjasa që meshkujt të përjetojnë depresion. Disa studime tregojnë se një e treta e grave do të përjetojnë një episod të madh depresiv në jetën e tyre.");
                textView3.setText("Diagnostifikohet nga mjeku internist dhe mjeku i pergjithshem. Diagnostifimi dhe trajtimi behet ne baze te simptomave" +
                        "por mjeku mund te udhezoje realizimin e testeve urinore dhe te gjakut per te konkluduar mbi komplikimet e mundshme.");
                textView4.setText("Gripi zakonisht kalohet brenda dy javeve pushimi. Pirja e antihistaminozeve dhe e ilaceve kunder dhimbjes, pirja" +
                        "e ujit deri ne 2L ne dite mund te ndihmoje ne permiresimin e simptomave. Zakonisht gripi keqesohet kur personi nuk pushon" +
                        "mjaftueshem, kur pi duhan ose nuk pi mjaftueshem lengje.");
                textView5.setText("Psikiatri, Psikologu");
                textView6.setText("Celexa, Lexapro, Prozac, Effexor");
            }
            if (sem.contains("Peunomi"))
            {
                textView.setText("Pneunomia");
                textView1.setText("Pnenomia është një infeksion që ndez thasët e ajrit në një ose të dy mushkëritë. Qeshet e ajrit mund të mbushen me lëngje ose qelb (material purulent), duke shkaktuar kollë me gëlbazë ose qelb, ethe, dridhura dhe vështirësi në frymëmarrje. Një shumëllojshmëri organizmash, përfshirë bakteret, viruset dhe kërpudhat, mund të shkaktojnë pneumoni.\n" +
                        "\n" +
                        "Pneunomia mund të jete jo shume e demshme e  mund te shkaktoje edhe vdekjen. Është më serioze për foshnjat dhe fëmijët e vegjël, njerëzit më të vjetër se 65 vjeç dhe njerëzit me probleme shëndetësore ose sisteme të dobëta imunitare.");
                textView2.setText("Shenjat dhe simptomat e pneumonisë ndryshojnë nga të lehta në të rënda, varësisht nga faktorë të tillë si lloji i embrionit që shkakton infeksionin, mosha juaj dhe shëndeti i përgjithshëm. Shenjat dhe simptomat e buta shpesh janë të ngjashme me ato të një ftohjeje apo gripit, por ato zgjasin më gjatë.\n" +
                        "\n" +
                        "Shenjat dhe simptomat e pneumonisë mund të përfshijnë:\n" +
                        "\n" +
                        "Dhimbje kraharori kur merrni frymë ose kolliteni\n" +
                        "Konfuzion ose ndryshime në ndërgjegjësimin mendor (në moshën 65 vjeç e lart)\n" +
                        "Kollë, e cila mund të prodhojë gëlbazë\n" +
                        "Lodhje\n" +
                        "Ethe, djersitje dhe të dridhura\n" +
                        "Temperature me e ulët se temperatura normale e trupit (në të rriturit më të vjetër se 65 vjeç dhe njerëzit me sistem imun të dobët)\n" +
                        "Te vjella ose diarre\n" +
                        "Shkurtesa te frymëmarrjes\n" +
                        "Të sapolindurit dhe foshnjat nuk mund të tregojnë ndonjë shenjë të infeksionit. Ose mund të vjellin, të kenë ethe dhe kollë, të duken të shqetësuar ose të lodhur dhe pa energji, ose të kenë vështirësi në frymëmarrje.");
                       textView3.setText("Pneumonia nganjëherë mund të jetë e vështirë për t'u diagnostikuar sepse simptomat janë të njëjta si për një të ftohtë të keq apo grip. Ju nuk mund të mendoni se duhet të shkoni tek mjeku derisa simptomat të zgjasin për një kohë të pazakontë të gjatë. Mjeku juaj do të diagnostikojë pneumoni bazuar në historinë tuaj mjekësore dhe rezultatet nga një provim fizik. Ai ose ajo do të dëgjojë mushkëritë tuaja me stetoskop. Ata gjithashtu mund të bëjnë disa teste, të tilla si një x-ray me gjoks ose një test gjaku. Një radiografi me gjoks mund t'i tregojë mjekut tuaj nëse keni pneumoni dhe sa i përhapur është infeksioni. Testet e gjakut dhe mukusit mund t'i ndihmojnë mjekut tuaj të tregojë nëse bakteret, një virus ose një organizëm kërpudhash po shkakton pneumoni.");
                       textView4.setText("Trajtimi për pneumoni përfshin shërimin e infeksionit dhe parandalimin e komplikimeve. Njerëzit që kanë pneumoni të fituar nga komuniteti zakonisht mund të trajtohen në shtëpi me ilaçe. Edhe pse simptomat lehtesohen disa ditë ose javë, ndjenja e lodhjes mund të vazhdojë për një muaj ose më shumë."
                               );
                       textView5.setText("Pulmolog");
                       textView6.setText("Iboprufen, Advdil, Tylenol, Azithromycin");
            }
            if (sem.contains("Apendicit") || sem.contains("Meningitis") || sem.contains("Sinus akut") || sem.contains("Diare") || sem.contains("Artritis") || sem.contains("Kancer"))
            {
               setContentView(R.layout.noinfo);
            }

    }
}
