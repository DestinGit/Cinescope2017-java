/* 
 * main.js
 */
function init() {
    console.log("Bonjour les amis 'init'");
    autoCompleteBarreRecherche();

}

/**
 * 
 * @returns {undefined}
 */
function autoCompleteBarreRecherche() {

    //mes variables
    var tListeFilms;
    var titreFilm;
    var tTitreAutoComplete = new Array();
    var jqXHR;

    //mon code ajax en$ get
    jqXHR = $.get(
            "/Cinescope2017Web/AutocompletionBarreRecherche",// l'url
            "json"//le type
            );
    jqXHR.done(function(data) {
        //console.log("ajax done");
        tListeFilms = JSON.parse(data);// data est une string d'un tableau d'objet json
        //console.log(tListeFilms.length);
        for (var i = 0; i < tListeFilms.length; i++) {// pour chaque objet du tableau de json
            //console.log(tListeFilms[i].titre);
            titreFilm = tListeFilms[i];
            tTitreAutoComplete.push(titreFilm.titre);// on récupère le titre du film et on l'incorpore a un tableau
        }
        $("#recherche").autocomplete({// sur l'imput sugegestion de noms j'opère l'autocomplete
            source: tTitreAutoComplete, //source : un tableau des noms de stations
            minLength: 3// on indique qu'il faut taper au moins 3 caractères pour afficher l'autocomplétion
        });//fin autocomplete
    });

}

// -------------------------------------------------------------------------------------------------------------------------------------
$(document).ready(init);// au chargement de la page, on demarre la fonction init