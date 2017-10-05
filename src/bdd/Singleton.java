/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bdd;

import java.io.Serializable;

/**
 *
 * @author formation
 */
public class Singleton implements Serializable
{	
	/** Constructeur privé */
	private Singleton()
	{}
 
	/** Instance unique pré-initialisée */
	private static Singleton INSTANCE = new Singleton();
 
	/** Point d'accès pour l'instance unique du singleton */
	public static Singleton getInstance()
	{	return INSTANCE;
	}
 
	/** Sécurité anti-désérialisation */
	private Object readResolve() {
		return INSTANCE;
	}
}