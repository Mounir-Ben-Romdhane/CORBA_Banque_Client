package CorbaClient;

import java.util.Scanner;

import javax.naming.Context;
import javax.naming.InitialContext;

import corbaBanque.Compte;
import corbaBanque.IBanqueRemote;
import corbaBanque.IBanqueRemoteHelper;

public class BanqueClient {
	public static void main(String[] args) {

		try {
		Context ctx = new InitialContext();
		 Object ref = ctx.lookup("BK");
		 IBanqueRemote stub=IBanqueRemoteHelper.narrow((org.omg.CORBA.Object)ref);
			System.out.println("\tBienvenu dans notre Banque !");
			
			for(int i=0;i<1000;i++) {
				System.out.println("\tChoisier votre operation :");
				System.out.println("1-Convertir un montant !\t2-ajouter un compte !\n3-Conselter compte !\t4-liste de comptes !\n5-Crediter un compte !\t6-Debiter un compte !");
				Scanner scan = new Scanner(System.in);
				char choix = scan.nextLine().charAt(0);
				
				switch(choix) {
				case '1' : {
				 System.out.println("Donner le montant en dinar :");
				 Double x= scan.nextDouble();
				 System.out.println("Ce montant en euro :");
				 System.out.println(stub.conv(x));
				 System.out.println("********************************************");
				 break;}
				 
				case '2' : {
				 System.out.println("Donner votre code :");
				 int id= scan.nextInt();
				 System.out.println("Donner votre montant :");
				 Double soulde= scan.nextDouble();
				 
				 Compte c = new Compte(id,soulde);
				 stub.creeCompte(c);
				 System.out.println("Compte ajouter avec sécces!");
				 System.out.println("********************************************");
				 break;
				}
				case '3' : {
					System.out.println("Donner le code de compte :");
					int id2= scan.nextInt();
					 System.out.println(stub.getCompte(id2).toString());
					 System.out.println("********************************************");
					 break;
					
				}
				case '4' : {
					System.out.println("La liste de comptes :");
					/*
					Compte[] cptes = stub.getComptes();
					 for(Compte cp:cptes) {
						 System.out.println(cp.toString());
					 }
					 */
					
					 Compte[] cptes = stub.getComptes();
					 for(Compte cp:cptes) {
						 System.out.println(cp.code+" -- "+cp.solde);
					 }
					
					 System.out.println("********************************************");
					break;
				}
				case '5' : {
					System.out.println("Donner le code de compte :");
					int id2= scan.nextInt();
					System.out.println("Donner la montant créditer :");
					 Double soulde= scan.nextDouble();
					 stub.verser(id2,soulde);
					 System.out.println("********************************************");
					 break;
				
				}
				
				case '6' : {
					System.out.println("Donner le code de compte :");
					int id2= scan.nextInt();
					System.out.println("Donner la montant retirer :");
					 Double soulde= scan.nextDouble();
					 stub.retirer(id2,soulde);
					 System.out.println("********************************************");
					 break;
				
				}
				}	
			}		 }catch (Exception e) { e.printStackTrace(); }
		 }
	}

