/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Ján
 */
public class Emittor {
    
    private static List<SpectralLine> GetDataFromFile(String fileName) throws Exception
    {
        FileInputStream in = new FileInputStream("hydrogen.txt");
        Scanner input = new Scanner(in);

        List<SpectralLine> result = new ArrayList<SpectralLine>();
        while(input.hasNextLine()){
            Scanner line = new Scanner(input.nextLine());
            line.useDelimiter(" ");
            String wavelength = line.next();
            
            String strength = line.next();
            while(strength.length() == 0)
            {
                strength = line.next();
            }
            
            SpectralLine newSpectralLine = new SpectralLine();
            newSpectralLine.strength = Float.parseFloat(strength);
            newSpectralLine.wavelength = Float.parseFloat(wavelength);
            result.add(newSpectralLine);
        }
        return result;
    }
    
    private static void CalculateRefractiveIndex(List<SpectralLine> list)
    {
        for(int i = 0; i < list.size(); i++)
        {
            SpectralLine s = list.get(i);
            s.wavelength /= 10.0f;
            s.n = s.wavelength / 350.0f * 1.6f;
        }
    }
    
    public static List<SpectralLine> GetHydrogen() throws Exception
    {
        List<SpectralLine> result = GetDataFromFile("hydrogen.txt");
        CalculateRefractiveIndex(result);
        return result;
    }
    
    public static List<SpectralLine> GetHelium() throws Exception
    {
        List<SpectralLine> result = GetDataFromFile("helium.txt");
        CalculateRefractiveIndex(result);
        return result;
    }
    
    public static List<SpectralLine> GetCarbon() throws Exception
    {
        List<SpectralLine> result = GetDataFromFile("carbon.txt");
        CalculateRefractiveIndex(result);
        return result;
    }
    
    public static List<SpectralLine> GetLithium() throws Exception
    {
        List<SpectralLine> result = GetDataFromFile("lithium.txt");
        CalculateRefractiveIndex(result);
        return result;
    }
    
    public static List<SpectralLine> GetNeon() throws Exception
    {
        List<SpectralLine> result = GetDataFromFile("neon.txt");
        CalculateRefractiveIndex(result);
        return result;
    }
    
    public static List<SpectralLine> GetOxygen() throws Exception
    {
        List<SpectralLine> result = GetDataFromFile("oxygen.txt");
        CalculateRefractiveIndex(result);
        return result;
    }
    
    public static List<SpectralLine> GetSilicon() throws Exception
    {
        List<SpectralLine> result = GetDataFromFile("silicon.txt");
        CalculateRefractiveIndex(result);
        return result;
    }
    
    public static List<SpectralLine> GetSulfur() throws Exception
    {
        List<SpectralLine> result = GetDataFromFile("sulfur.txt");
        CalculateRefractiveIndex(result);
        return result;
    }
    
    public static List<SpectralLine> GetSodium() throws Exception
    {
        List<SpectralLine> result = GetDataFromFile("sodium.txt");
        CalculateRefractiveIndex(result);
        return result;
    }
    
     public static void main(String args[]) {
        try
        {
            List<SpectralLine> a = Emittor.GetHydrogen();
            int x = 12;
        } catch(Exception e)
        {
        }
        
    }
    
}
