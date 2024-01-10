package ma.fstt.marketplace.controller;

import android.content.Context;

import ma.fstt.marketplace.model.UserClient;
import ma.fstt.marketplace.model.UserSupplier;
import ma.fstt.marketplace.tools.SqLiteAccessRequest;

public class CpageAccueil {
    private SqLiteAccessRequest sqLiteAccessRequest;
    //private UtilisateurAc utilisateur;
    private Context context;

    //Constructeur CpageAccueil retournant le contenu du constructeur Object.
    public CpageAccueil(Context context) {
        this.context=context;
    }

    /**
     * Permet de tester le type de l'utilisateur pour les conditions du MainActivity
     * (utilisé dans le main activity pour ses conditions)
     * @param username
     * @param password
     * @return
     */
    public String getTypeUser(String username, String password){
        sqLiteAccessRequest= new SqLiteAccessRequest(context);
        String verif = sqLiteAccessRequest.verifTypeUser(username, password);
        sqLiteAccessRequest.close();
        return verif;
    }

    /**
     * Récupération de l'objet utilisateur de type "acheteur" permettant l'accès à ses attributs.
     * @param username
     */
    public UserClient getConnexionAC(String username){

        //Ouverture d'une connexion à la base de données.
        sqLiteAccessRequest= new SqLiteAccessRequest(context);

        //Récupération de l'objet utilisateur de la méthode connexionAC de l'outil SqLiteAccessRequest
        UserClient utilisateur = sqLiteAccessRequest.connexionAC(username);
        sqLiteAccessRequest.close();
        return utilisateur;
    }
    /**
     * Récupération de l'objet utilisateur de type "fournisseur" permettant l'accès à ses attributs.
     * @param username
     */
    public UserSupplier getConnexionFO(String username){
        //Ouverture d'une connexion à la base de données.
        sqLiteAccessRequest= new SqLiteAccessRequest(context);

        UserSupplier user = sqLiteAccessRequest.connexionFo(username);
        sqLiteAccessRequest.close();
        return user;
    }
}

