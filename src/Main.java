import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import barangDagangan.Buah;
import barangDagangan.Kendaraan;

public class Main {
	Scanner scan = new Scanner(System.in);
	ArrayList<Kendaraan> dataKendaraan = new ArrayList<Kendaraan>();
	// buat objek apel
//	Buah apel = new Buah("Apel", 50, 2.51);
	// objek lain namanya pisang
//	Buah pisang = new Buah("Pisang", 100, 1.2323);
	
//	Kendaraan mobil = new Kendaraan("mobil", 4, "bensin");
	public Main() {
//		System.out.println("Nama buah: " + apel.nama);
//		System.out.println("Kualitas buah: " + apel.kualitas);
//		System.out.println("Berat buah: " + apel.berat);
//		
//		System.out.println();
//		
//		System.out.println("Nama kendaraan: " + mobil.nama);
//		System.out.println("Jumlah roda: " + mobil.jumlahRoda);
//		System.out.println("Bahan bakar: " + mobil.bahanBakar);
		// menu dealer kendaraaan, data kendaraan yang masuk
		
//		calculator();
		
		int input = 0;
		
		do {
			printMenu();
			input = scanInteger();
			handleMenu(input);
		} while (input!=0);
		
		try {
//			createFile();
//			fileReader();
//			fileScanner();
//			fileWriter();
//			fileWriter2();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	void fileWriter() throws Exception {
		FileOutputStream writer = new FileOutputStream("invoice.txt");
		
		String input = "Ikan goreng";
		
		for(int i =0; i<input.length(); i++) {
			writer.write((int)input.charAt(i));
		}
		
	}
	
	void fileWriter2() throws Exception {
		FileWriter writer = new FileWriter("invoice.txt");
		
		String input = "Ikan goreng";
		writer.write(input);
		writer.write("\nayam bakar");
		writer.close();
		System.out.println("done writing");
		
	}

	void createFile() throws IOException  {
		File file = new File("invoice.txt");
		
		if(!file.exists()) {
			file.createNewFile();
			System.out.println("Created new file!");
		}
		
		System.out.println("File path: " + file.getPath());
		System.out.println("File absolute path: " + file.getAbsolutePath());
	}
	
	void fileReader() throws Exception {
		FileReader fileReader = new FileReader("invoice.txt");
		int data = fileReader.read();
		
		while (data != -1) {
			System.out.print((char)data);
			data = fileReader.read();
		}
	}
	
	void fileScanner() throws FileNotFoundException {
		File file = new File("invoice.txt");
		Scanner fileScan = new Scanner(file);
		
		while (fileScan.hasNextLine()) {
			String data = fileScan.nextLine();
			System.out.println(data);	
		}
		fileScan.close();
	}
	
	void calculator() {
		
		try {
			System.out.println("Masukkan input 1");
			int input1 = scan.nextInt();
			scan.nextLine();
			
			System.out.println("Masukkan input 2");
			int input2 = scan.nextInt();
			scan.nextLine();
			
			System.out.println(input1/input2);
			
		}catch (ArithmeticException e) {
			System.err.println("Perhitungan error, karena: " + e.getMessage());
		}catch (InputMismatchException e) {
			System.err.println("Ada yang salah dengan inputnya, karena: " + e.toString());
		}catch (Exception e) {
			System.err.println("Ada yang salah disini, karena: " + e.toString());
		}


		
	}
	
	int scanInteger() {
		int input = 0;
		try {
			input = scan.nextInt();
			scan.nextLine();
		}
		catch (Exception e) {
			System.err.println("Input harus berupa integer!");
		}
		
		return input;
	}
	
	void printMenu() {
		System.out.println("Welcome to dealer");
		System.out.println("1. Insert kendaraan");
		System.out.println("2. Print kendaraan");
		System.out.println("3. Print invoice");
		System.out.print("Insert menu: ");
	}
	
	void handleMenu(int input) {
		switch (input) {
		case 1:
			createKendaraan();
			break;
		case 2:
			viewKendaraan();
		case 3:
			printInvoice();
		default:
			break;
		}
	}
	
	void printInvoice() {
		int input;
		viewKendaraan();
		
		System.out.println("Masukkan nomor kendaraan yang ingin di print invoicenya");
		
		input = scanInteger();
		
		Kendaraan kendaraan = dataKendaraan.get(input);
		
		File invoiceBaru = new File("Invoice-" + kendaraan.nama + ".txt");
		
		try {
			writeInvoice("Invoice-" + kendaraan.nama + ".txt", kendaraan);
		} catch (Exception e) {
			System.err.println(e);
		}
		
		
	}
	
	void writeInvoice (String namaFile, Kendaraan kendaraan) throws IOException {
		FileWriter writer = new FileWriter(namaFile);
		
		writer.write("Nama kendaraan: " + kendaraan.nama);
		writer.write("\nJumlah roda kendaraan: " + kendaraan.jumlahRoda);
		writer.write("\nJenis bahan bakar kendaraan: " + kendaraan.bahanBakar);
		writer.write("\nHarga kendaraan: " + (kendaraan.jumlahRoda * 10000));
		writer.close();
		System.out.println("done writing invoice");
	}
	
	private void viewKendaraan() {
		System.out.println();
		System.out.println("NO |   Nama   |   Jumlah roda   |   Bahan bakar   |");
		for(int i = 0; i < dataKendaraan.size(); i++) {
			System.out.printf("%d |%s|%10d|%s|\n", i, dataKendaraan.get(i).nama,
					dataKendaraan.get(i).jumlahRoda, dataKendaraan.get(i).bahanBakar);
		}
		
	}

	void createKendaraan() {
		String nama;
		int jumlahRoda;
		String bahanBakar;
		
		System.out.print("Masukkan nama kendaraan: ");
		nama = scan.nextLine();
		
		System.out.print("Masukkan jumlah roda: ");
		jumlahRoda = scanInteger();
		
		System.out.print("Masukkan jenis bahan bakar: ");
		bahanBakar = scan.nextLine();
		
		Kendaraan kendaraanBaru = new Kendaraan(nama, jumlahRoda, bahanBakar);
		dataKendaraan.add(kendaraanBaru);
		System.out.println();
	}

	public static void main(String[] args) {
		new Main();

	}

}
