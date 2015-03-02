package database.create;

import database.ConnectionDB;

import java.sql.*;

/**
 * Created by DL on 02/03/2015.
 */
public class CreateProduct {
    private PreparedStatement pstmt;
    private Statement stmt;
    private ResultSet rset;
    private Connection conn;

    public void dropProductTable(Connection connIn) {
        try {
            this.conn = connIn;
            stmt = conn.createStatement();
            try {
                stmt.execute("DROP TABLE Product");
                System.out.println("Table dropped successfully");
                stmt.execute("DROP SEQUENCE productSeq");
                System.out.println("Sequence dropped successfully");
            } catch (SQLException ex) {
                System.out.println("Error dropping table or they may not exist");
            }
        } catch (SQLException e) {
            //System.out.println(e);
            System.out.println("Error with connection");
        }
    }

    public void createProductTable() {
        try {
            stmt = conn.createStatement();

            //create product table
            stmt.execute("CREATE TABLE Product(" +
                    "prodId INTEGER," +
                    "prodMake VARCHAR2(100)," +
                    "prodModel VARCHAR2(100)," +
                    "prodSalePrice NUMBER(6,2)," +
                    "prodCostPrice NUMBER(6,2)," +
                    "prodQTY INTEGER," +
                    "prodPic BLOB," +
                    "prodType VARCHAR(20)," +
                    "cpu VARCHAR2(50)," +
                    "ram VARCHAR2(30)," +
                    "operatingSystem VARCHAR2(30)," +
                    "storage VARCHAR2(30)," +
                    "screen VARCHAR2(30)," +
                    "prodDesc VARCHAR2(500)," +
                    "PRIMARY KEY (prodId))");
            System.out.println("Table created successfully");

            //create product sequence
            stmt.execute("CREATE SEQUENCE productSeq START WITH 100000 INCREMENT BY 1");
            System.out.println("Product sequence created successfully");

            //create prepared statement
            String sql = "INSERT INTO Product (prodId, prodMake, prodModel, prodSalePrice, prodCostPrice, " +
                    "prodQTY, prodPic, prodType, cpu, ram, operatingSystem, storage, screen, prodDesc) VALUES " +
                    "(productSeq.nextVal,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            pstmt = conn.prepareStatement(sql);

            //Desktops
            //Product 1
            pstmt.setString(1, "ASUS");//prodMake
            pstmt.setString(2, "M32BF");//prodModel
            pstmt.setDouble(3, 269.99);//prodSalePrice
            pstmt.setDouble(4, 229.99);//prodCostPrice
            pstmt.setInt(5, 11);//prodQTY
            pstmt.setString(6, null);//prodPic
            pstmt.setString(7, "Desktop");//prodType
            pstmt.setString(8, "Intel Pentium G2030 Processor");//cpu
            pstmt.setString(9, "4 GB DDR3 - 1600 MHz");//ram
            pstmt.setString(10, "Windows 8.1 64-bit Edition");//operatingSystem
            pstmt.setString(11, "1 TB – SATA HDD");//storage
            pstmt.setString(12, "24\" LED");//screen
            pstmt.setString(13, "Ideal as a first computer or for your home office, the Advent DT4102 " +
                    "Barebones Desktop PC has all the features you need for home computing");//prodDesc
            pstmt.execute();

            //Desktops
            //Product 2
            pstmt.setString(1, "LENOVO");//prodMake
            pstmt.setString(2, "H500S");//prodModel
            pstmt.setDouble(3, 299.99);//prodSalePrice
            pstmt.setDouble(4, 254.99);//prodCostPrice
            pstmt.setInt(5, 12);//prodQTY
            pstmt.setString(6, null);//prodPic
            pstmt.setString(7, "Desktop");//prodType
            pstmt.setString(8, "Intel Pentium Processor J2900");//cpu
            pstmt.setString(9, "4 GB DDR3 - 1600 MHz");//ram
            pstmt.setString(10, "Windows 8.1 64-bit Edition");//operatingSystem
            pstmt.setString(11, "500 GB – SATA HDD");//storage
            pstmt.setString(12, "21\" LCD");//screen
            pstmt.setString(13, "The affordable Lenovo H500s desktop uniquely combines a slim space-saving" +
                    " design with the latest processor technology and plenty of storage space for everyday" +
                    " home computing.");//prodDesc
            pstmt.execute();

            //Desktops
            //Product 3
            pstmt.setString(1, "LENOVO");//prodMake
            pstmt.setString(2, "Q190");//prodModel
            pstmt.setDouble(3, 279.99);//prodSalePrice
            pstmt.setDouble(4, 237.99);//prodCostPrice
            pstmt.setInt(5, 13);//prodQTY
            pstmt.setString(6, null);//prodPic
            pstmt.setString(7, "Desktop");//prodType
            pstmt.setString(8, "Intel Pentium Processor J2900");//cpu
            pstmt.setString(9, "4 GB DDR3 - 1600 MHz");//ram
            pstmt.setString(10, "Windows 7 64-bit Edition");//operatingSystem
            pstmt.setString(11, "500 GB – SATA HDD");//storage
            pstmt.setString(12, "27\" LED");//screen
            pstmt.setString(13, "The H30 comes pre-installed with the expressive Windows 8.1 operating system." +
                    " Packed full of intuitive apps, it gives you the information that's important to you as " +
                    "soon as you need it. The contemporary and stylish Lenovo H30 is around half the size of a" +
                    " regular desktop PC, ideal for fitting into rooms where space is at a premium. " +
                    "The supplied AccuType keyboard features ergonomic keys for comfortable and accurate " +
                    "typing.");//prodDesc
            pstmt.execute();

            //Desktops
            //Product 4
            pstmt.setString(1, "CYBERPOWER");//prodMake
            pstmt.setString(2, "Empire Elite");//prodModel
            pstmt.setDouble(3, 679.99);//prodSalePrice
            pstmt.setDouble(4, 577.99);//prodCostPrice
            pstmt.setInt(5, 14);//prodQTY
            pstmt.setString(6, null);//prodPic
            pstmt.setString(7, "Desktop");//prodType
            pstmt.setString(8, "AMD FX 4300 processor");//cpu
            pstmt.setString(9, "8 GB DDR3 - 1600 MHz");//ram
            pstmt.setString(10, "Windows 8.1 64-bit Edition");//operatingSystem
            pstmt.setString(11, "1 TB – SATA HDD");//storage
            pstmt.setString(12, "22\" LED");//screen
            pstmt.setString(13, "Take your first exciting steps on the ladder to high-end PC gaming with the" +
                    " Cyberpower Empire Elite Gaming PC. The Empire Elite is powered by a rapid AMD FX 4300 " +
                    "processor. Featuring four cores, a 3.8 GHz clock speed and 4 MB cache memory, it provides" +
                    " fast, uninterrupted gaming and is even capable of specialist tasks such as music " +
                    "production and media editing.");//prodDesc
            pstmt.execute();

            //Desktops
            //Product 5
            pstmt.setString(1, "PC SPECIALIST");//prodMake
            pstmt.setString(2, "Vortex Elite GT");//prodModel
            pstmt.setDouble(3, 669.99);//prodSalePrice
            pstmt.setDouble(4, 569.99);//prodCostPrice
            pstmt.setInt(5, 15);//prodQTY
            pstmt.setString(6, null);//prodPic
            pstmt.setString(7, "Desktop");//prodType
            pstmt.setString(8, "Intel Core i3-4160 Processor");//cpu
            pstmt.setString(9, "8 GB DDR3 - 1600 MHz");//ram
            pstmt.setString(10, "Windows 7 64-bit Edition");//operatingSystem
            pstmt.setString(11, "500 GB – SATA HDD");//storage
            pstmt.setString(12, "24\" LED");//screen
            pstmt.setString(13, "Start your journey into the exciting world of PC gaming with the PC Specialist" +
                    " Vortex Elite GT Gaming PC. The Vortex Elite GT is great way to start your journey into PC" +
                    " gaming. From popular AAA title to classic RPGs and MMOs, it features everything you need" +
                    " to start downloading and playing the wealth of PC games available today.");//prodDesc
            pstmt.execute();

            //Desktops
            //Product 6
            pstmt.setString(1, "ACER");//prodMake
            pstmt.setString(2, "Aspire TC-605");//prodModel
            pstmt.setDouble(3, 649.00);//prodSalePrice
            pstmt.setDouble(4, 551.99);//prodCostPrice
            pstmt.setInt(5, 19);//prodQTY
            pstmt.setString(6, null);//prodPic
            pstmt.setString(7, "Desktop");//prodType
            pstmt.setString(8, "Intel Core i7-4770 processor");//cpu
            pstmt.setString(9, "8 GB DDR3 - 1600 MHz");//ram
            pstmt.setString(10, "Windows 8.1 64-bit Edition");//operatingSystem
            pstmt.setString(11, "2 TB – SATA HDD");//storage
            pstmt.setString(12, "30\" LED");//screen
            pstmt.setString(13, "With powerful Intel® processing and large capacity storage, the Acer Aspire " +
                    "TC-605 Barebones Desktop PC is the perfect starting point for your gaming, media or design" +
                    " set-up. Processing power comes courtesy of a quad-core Intel® Core™ i7-4770 which boasts " +
                    "a rapid 3.9 GHz TurboBoost clock speed, 8 MB cache memory and Hyper-Threading " +
                    "technology.");//prodDesc
            pstmt.execute();

            //Desktops
            //Product 7
            pstmt.setString(1, "ACER");//prodMake
            pstmt.setString(2, "Aspire XC-703");//prodModel
            pstmt.setDouble(3, 499.99);//prodSalePrice
            pstmt.setDouble(4, 424.99);//prodCostPrice
            pstmt.setInt(5, 18);//prodQTY
            pstmt.setString(6, null);//prodPic
            pstmt.setString(7, "Desktop");//prodType
            pstmt.setString(8, "Intel Pentium Processor J2900");//cpu
            pstmt.setString(9, "8 GB DDR3 - 1600 MHz");//ram
            pstmt.setString(10, "Windows 8.1 64-bit Edition");//operatingSystem
            pstmt.setString(11, "1 TB – SATA HDD");//storage
            pstmt.setString(12, "20\" LED");//screen
            pstmt.setString(13, "With powerful quad-core processing and an impressive 1 TB hard drive, the Acer" +
                    " Aspire XC-703 Desktop PC is ideal for family computing." +
                    "Perfect for use by the whole family, the Aspire XC-703 features 1 TB of hard drive space " +
                    "for you to store your latest family photo adventures, current school project documents " +
                    "and family favourite games.");//prodDesc
            pstmt.execute();

            //Desktops
            //Product 8
            pstmt.setString(1, "HP");//prodMake
            pstmt.setString(2, "Pavilion 500-326na");//prodModel
            pstmt.setDouble(3, 529.99);//prodSalePrice
            pstmt.setDouble(4, 450.99);//prodCostPrice
            pstmt.setInt(5, 19);//prodQTY
            pstmt.setString(6, null);//prodPic
            pstmt.setString(7, "Desktop");//prodType
            pstmt.setString(8, "AMD A8-6500 APU");//cpu
            pstmt.setString(9, "6 GB DDR3 - 1600 MHz");//ram
            pstmt.setString(10, "Windows 8.1 64-bit Edition");//operatingSystem
            pstmt.setString(11, "1 TB – SATA SSD");//storage
            pstmt.setString(12, "20\" LED");//screen
            pstmt.setString(13, "Experience powerful everyday computing and impressive dedicated graphics with " +
                    "the HP Pavilion 500-326na Desktop PC. The Pavilion 500 is powered by a quad-core AMD " +
                    "A8-6500 APU. An APU combines a processor and graphics card in one efficient chip for fast " +
                    "everyday performance with impressive visuals.");//prodDesc
            pstmt.execute();

            //Desktops
            //Product 9
            pstmt.setString(1, "ASUS");//prodMake
            pstmt.setString(2, "M11AD");//prodModel
            pstmt.setDouble(3, 519.99);//prodSalePrice
            pstmt.setDouble(4, 229.99);//prodCostPrice
            pstmt.setInt(5, 9);//prodQTY
            pstmt.setString(6, null);//prodPic
            pstmt.setString(7, "Desktop");//prodType
            pstmt.setString(8, "Intel Core i3-4150 Processor");//cpu
            pstmt.setString(9, "6 GB DDR3 - 1600 MHz");//ram
            pstmt.setString(10, "Windows 8.1 64-bit Edition");//operatingSystem
            pstmt.setString(11, "1 TB – SATA HDD");//storage
            pstmt.setString(12, "24\" LED");//screen
            pstmt.setString(13, "The Asus M11AD Desktop PC runs on Windows 8.1 and offers fast, reliable spec" +
                    " to keep you as productive or entertained as you need to be. Running on an Intel® Core™ " +
                    "i3-4150 Processor beefed up by 6 GB of RAM, the Asus M11AD Desktop PC is able to give you" +
                    " more speed and more power. Its Intel® Turbo Boost Technology 2.0 allows the processor " +
                    "cores to run faster than the base operating frequency.");//prodDesc
            pstmt.execute();

            //Desktops
            //Product 10
            pstmt.setString(1, "PACKARD BELL");//prodMake
            pstmt.setString(2, "iMedia S 2185");//prodModel
            pstmt.setDouble(3, 299.99);//prodSalePrice
            pstmt.setDouble(4, 254.99);//prodCostPrice
            pstmt.setInt(5, 23);//prodQTY
            pstmt.setString(6, null);//prodPic
            pstmt.setString(7, "Desktop");//prodType
            pstmt.setString(8, "AMD E1-2500 Processor");//cpu
            pstmt.setString(9, "4 GB DDR3 - 1600 MHz");//ram
            pstmt.setString(10, "Windows 8.1 64-bit Edition");//operatingSystem
            pstmt.setString(11, "500 GB – SATA HDD");//storage
            pstmt.setString(12, "24\" LED");//screen
            pstmt.setString(13, "Create the computer you need with the compact Packard Bell iMedia S 2185 " +
                    "Barebones Desktop PC. Whether you writing essays, shopping online or chatting to far-away " +
                    "friends, the iMedia S delivers reliable everyday computing thanks to an AMD E1-2500 " +
                    "APU.");//prodDesc
            pstmt.execute();



            //Laptops
            //Product 1
            pstmt.setString(1, "ACER");//prodMake
            pstmt.setString(2, "E5-511");//prodModel
            pstmt.setDouble(3, 419.99);//prodSalePrice
            pstmt.setDouble(4, 356.99);//prodCostPrice
            pstmt.setInt(5, 21);//prodQTY
            pstmt.setString(6, null);//prodPic
            pstmt.setString(7, "Laptop");//prodType
            pstmt.setString(8, "Intel Pentium N3540 Processor");//cpu
            pstmt.setString(9, "4 GB");//ram
            pstmt.setString(10, "Windows 8.1 64-Bit Edition");//operatingSystem
            pstmt.setString(11, "1 TB");//storage
            pstmt.setString(12, "15.6\" LED");//screen
            pstmt.setString(13, "The Aspire E5-511 boasts a seven-hour battery life, making it ideal for" +
                    " working away from the office or studying in the library. A full size Acer FineTip " +
                    "keyboard offers comfortable and quiet typing, and is designed to avoid " +
                    "typos.");//prodDesc
            pstmt.execute();

            //Laptops
            //Product 2
            pstmt.setString(1, "Dell");//prodMake
            pstmt.setString(2, "E7440");//prodModel
            pstmt.setDouble(3, 1599.99);//prodSalePrice
            pstmt.setDouble(4, 1359.99);//prodCostPrice
            pstmt.setInt(5, 15);//prodQTY
            pstmt.setString(6, null);//prodPic
            pstmt.setString(7, "Laptop");//prodType
            pstmt.setString(8, "Intel Core i5 processor");//cpu
            pstmt.setString(9, "8 GB ");//ram
            pstmt.setString(10, "Windows 7 Professional");//operatingSystem
            pstmt.setString(11, "128GB solid-state drive");//storage
            pstmt.setString(12, "14\" LED backlit");//screen
            pstmt.setString(13, "Enjoy fast, Full HD computing on the go with the Dell Latitude E7440 14\" " +
                    "Laptop. Full HD display offers impressive visuals for all your everyday computing, " +
                    "Fast browsing, loading and performance thanks to Intel Core™ processing. The 14\" " +
                    "screen is LED backlit so pictures are filled with brighter colours – it's the ideal " +
                    "combination of portability and workspace for computing on the go.");//prodDesc
            pstmt.execute();

            //Laptops
            //Product 3
            pstmt.setString(1, "ASUS");//prodMake
            pstmt.setString(2, "X200MA");//prodModel
            pstmt.setDouble(3, 259.99);//prodSalePrice
            pstmt.setDouble(4, 220.99);//prodCostPrice
            pstmt.setInt(5, 19);//prodQTY
            pstmt.setString(6, null);//prodPic
            pstmt.setString(7, "Laptop");//prodType
            pstmt.setString(8, "");//cpu
            pstmt.setString(9, "2 GB ");//ram
            pstmt.setString(10, "Windows 8");//operatingSystem
            pstmt.setString(11, "500 GB HDD, 5400 rpm");//storage
            pstmt.setString(12, "11.6\" LED  ");//screen
            pstmt.setString(13, "The X200MA comes pre-installed with the expressive Windows 8 operating " +
                    "system. Packed full of intuitive apps and features, it gives you the information that's" +
                    " important to you as soon as you need it. The Start screen is based around Live Tiles. " +
                    "These program icons display real time information from all your favourite apps " +
                    "including social networking, emails, news and sports directly on the home screen. " +
                    "You don't even have to open the program to receive important info and " +
                    "notifications.");//prodDesc
            pstmt.execute();

            //Laptops
            //Product 4
            pstmt.setString(1, "Maingear");//prodMake
            pstmt.setString(2, "The Pulse 17");//prodModel
            pstmt.setDouble(3, 2055.99);//prodSalePrice
            pstmt.setDouble(4, 1747.59);//prodCostPrice
            pstmt.setInt(5, 14);//prodQTY
            pstmt.setString(6, null);//prodPic
            pstmt.setString(7, "Laptop");//prodType
            pstmt.setString(8, "Intel Core i7 4700MQ");//cpu
            pstmt.setString(9, "16 GB");//ram
            pstmt.setString(10, "");//operatingSystem
            pstmt.setString(11, "128GB mSATA SSD");//storage
            pstmt.setString(12, "18\" LED");//screen
            pstmt.setString(13, "NVIDIA Optimus graphics technology delivers long battery life when you " +
                    "need it, and maximum frame rates when you don’t. Get 1344 CUDA cores operating at " +
                    "941MHz + Boost – over twice the performance of the previous generation, for incredible" +
                    " 3D visuals in the latest, most intensive games. And with a FullHD 1080p screen, the " +
                    "clarity and detail are truly amazing");//prodDesc
            pstmt.execute();

            //Laptops
            //Product 5
            pstmt.setString(1, "LENOVO");//prodMake
            pstmt.setString(2, "Flex");//prodModel
            pstmt.setDouble(3, 329.99);//prodSalePrice
            pstmt.setDouble(4, 280.49);//prodCostPrice
            pstmt.setInt(5, 11);//prodQTY
            pstmt.setString(6, null);//prodPic
            pstmt.setString(7, "Laptop");//prodType
            pstmt.setString(8, "Intel Celeron Processor N2840");//cpu
            pstmt.setString(9, "4GB");//ram
            pstmt.setString(10, "Windows 8.1 64-bit Edition");//operatingSystem
            pstmt.setString(11, "320 GB");//storage
            pstmt.setString(12, "10.1\" LED");//screen
            pstmt.setString(13, "Ideal as a first computer or for your home office, the Advent DT4102 " +
                    "Barebones Desktop PC has all the features you need for home computing");//prodDesc
            pstmt.execute();

            //Laptops
            //Product 6
            pstmt.setString(1, "TOSHIBA ");//prodMake
            pstmt.setString(2, "Satellite C50-B-14D");//prodModel
            pstmt.setDouble(3, 279.00);//prodSalePrice
            pstmt.setDouble(4, 237.00);//prodCostPrice
            pstmt.setInt(5, 14);//prodQTY
            pstmt.setString(6, null);//prodPic
            pstmt.setString(7, "Laptop");//prodType
            pstmt.setString(8, "Intel Celeron Processor N2830  ");//cpu
            pstmt.setString(9, "4 GB ");//ram
            pstmt.setString(10, "Windows 8.1 64-bit Edition");//operatingSystem
            pstmt.setString(11, "500 GB");//storage
            pstmt.setString(12, "15.6\" LED");//screen
            pstmt.setString(13, "The slim black Toshiba Satellite C50-B-14D 15.6\" Laptop is a great laptop" +
                    " for home or travel. The sleek design is perfect for any home, whilst the tiled " +
                    "keyboard and large touch pad make it easy to use. The DTS Sound technology on the " +
                    "Satellite C50-B14D provides smooth and deep bass alongside crisp speech, so music and " +
                    "videos will sound great. Immerse yourself in your music with the integrated stereo " +
                    "speakers.");//prodDesc
            pstmt.execute();

            //Laptops
            //Product 7
            pstmt.setString(1, "Sony Vaio");//prodMake
            pstmt.setString(2, "15E SVF1521D6EW");//prodModel
            pstmt.setDouble(3, 599.99);//prodSalePrice
            pstmt.setDouble(4, 509.99);//prodCostPrice
            pstmt.setInt(5, 14);//prodQTY
            pstmt.setString(6, null);//prodPic
            pstmt.setString(7, "Laptop");//prodType
            pstmt.setString(8, "Intel  Core i3-3217U processor");//cpu
            pstmt.setString(9, "4 GB ");//ram
            pstmt.setString(10, "Windows 8.1 64-bit Edition");//operatingSystem
            pstmt.setString(11, "1 TB");//storage
            pstmt.setString(12, "15.6” LED");//screen
            pstmt.setString(13, "The Aspire E5-511 boasts a seven-hour battery life, making it ideal for " +
                    "working away from the office or studying in the library. A full size Acer FineTip " +
                    "keyboard offers comfortable and quiet typing, and is designed to avoid " +
                    "typos.");//prodDesc
            pstmt.execute();

            //Laptops
            //Product 8
            pstmt.setString(1, "HP");//prodMake
            pstmt.setString(2, "Stream 11-d007na");//prodModel
            pstmt.setDouble(3, 249.99);//prodSalePrice
            pstmt.setDouble(4, 225.99);//prodCostPrice
            pstmt.setInt(5, 19);//prodQTY
            pstmt.setString(6, null);//prodPic
            pstmt.setString(7, "Laptop");//prodType
            pstmt.setString(8, "Intel Celeron Processor N2840");//cpu
            pstmt.setString(9, "2 GB ");//ram
            pstmt.setString(10, "Windows 8.1 64-bit Edition");//operatingSystem
            pstmt.setString(11, "32GB solid-state drive");//storage
            pstmt.setString(12, "11” LCD backlit");//screen
            pstmt.setString(13, "Stay productive and get connected with what matters with the HP Stream " +
                    "11-d007na 11\" Laptop. Includes one year subscription to Microsoft Office for complete" +
                    " productivity on the go. Impressively light and portable and Great-value laptop that " +
                    "comes with everything you need for daily computing.");//prodDesc
            pstmt.execute();

            //Laptops
            //Product 9
            pstmt.setString(1, "Optimus");//prodMake
            pstmt.setString(2, "V RS15");//prodModel
            pstmt.setDouble(3, 1279.00);//prodSalePrice
            pstmt.setDouble(4, 1087.15);//prodCostPrice
            pstmt.setInt(5, 13);//prodQTY
            pstmt.setString(6, null);//prodPic
            pstmt.setString(7, "Laptop");//prodType
            pstmt.setString(8, "Intel Core i7-4710MQ Processor ");//cpu
            pstmt.setString(9, "8 GB DDR3 - 1600 MHz");//ram
            pstmt.setString(10, "Windows 8.1 64-bit Edition");//operatingSystem
            pstmt.setString(11, "1 TB HDD - 7200 rpm");//storage
            pstmt.setString(12, "15.6\" LED");//screen
            pstmt.setString(13, "Enjoy gaming on the move with the high-powered PC Specialist Optimus V " +
                    "RS15 PCS-L651567 15.6\" Gaming Laptop. It also boasts an impressive 8 GB of Kingston " +
                    "memory for smooth computing and effortless multitasking. There are also premium Onkyo" +
                    " speakers, which consist of high quality components to give your sound the power it " +
                    "needs.");//prodDesc
            pstmt.execute();

            //Laptops
            //Product 10
            pstmt.setString(1, "XMG");//prodMake
            pstmt.setString(2, "P504");//prodModel
            pstmt.setDouble(3, 1899.99);//prodSalePrice
            pstmt.setDouble(4, 1600.59);//prodCostPrice
            pstmt.setInt(5, 17);//prodQTY
            pstmt.setString(6, null);//prodPic
            pstmt.setString(7, "Laptop");//prodType
            pstmt.setString(8, "Intel Core i7-4710MQ Processor");//cpu
            pstmt.setString(9, "8 GB DDR3");//ram
            pstmt.setString(10, "Windows 8.1");//operatingSystem
            pstmt.setString(11, "1 TB SSHD - 5400 rpm");//storage
            pstmt.setString(12, "15.6\" LED");//screen
            pstmt.setString(13, "With quad-core Intel Core i7 processing, NVIDIA GTX 870M graphics and " +
                    "features for the serious gamer, the XMG P504 15.6” Gaming Laptop is ready for the most" +
                    " demanding modern games wherever you are. 8 GB of 1600 MHz Crucial RAM keep things " +
                    "running smoothly and is easily sufficient for gaming, though you can add up to a " +
                    "colossal 32 GB should you need it in the future.");//prodDesc
            pstmt.execute();

            //ALL-IN-ONE
            //Product 1
            pstmt.setString(1, "LENOVO");//prodMake
            pstmt.setString(2, "C260");//prodModel
            pstmt.setDouble(3, 449.99);//prodSalePrice
            pstmt.setDouble(4, 379.99);//prodCostPrice
            pstmt.setInt(5, 16);//prodQTY
            pstmt.setString(6, null);//prodPic
            pstmt.setString(7, "All-In-One");//prodType
            pstmt.setString(8, "Intel Pentium Processor J2900");//cpu
            pstmt.setString(9, "4 GB - 1600 MHz");//ram
            pstmt.setString(10, "Windows 8.1");//operatingSystem
            pstmt.setString(11, "1 TB SATA HDD");//storage
            pstmt.setString(12, "19.5\" LED");//screen
            pstmt.setString(13, "The Lenovo C260 features everything you need for comprehensive home " +
                    "computing in one convenient package, including a 19.5” widescreen that incorporates " +
                    "the base unit, DVD drive and 6-in-1 card reader. The compact size makes it perfect " +
                    "for smaller rooms or simply placing on a table as there's no need to worry about where" +
                    " to locate the base unit - simply plug the power cable, mouse and keyboard in to get " +
                    "started.");//prodDesc
            pstmt.execute();

            //ALL-IN-ONE
            //Product 2
            pstmt.setString(1, "LENOVO");//prodMake
            pstmt.setString(2, "A740");//prodModel
            pstmt.setDouble(3, 2099.99);//prodSalePrice
            pstmt.setDouble(4, 1744.99);//prodCostPrice
            pstmt.setInt(5, 22);//prodQTY
            pstmt.setString(6, null);//prodPic
            pstmt.setString(7, "All-In-One");//prodType
            pstmt.setString(8, "Intel Core i7-4558U Processor");//cpu
            pstmt.setString(9, "8 GB  - 1600 MHz");//ram
            pstmt.setString(10, "Windows 8");//operatingSystem
            pstmt.setString(11, "2 TB HDD");//storage
            pstmt.setString(12, "27\" Touchscreen");//screen
            pstmt.setString(13, "Enjoy premium touchscreen computing with the thin and stylish Lenovo A740 " +
                    "27\" Touchscreen All-in-One PC. The Lenovo A740 is powered by a dual-core Intel Core " +
                    "i7-4558U processor that delivers fast, reliable computing whatever the task thanks to" +
                    " a 3.3 GHz TurboBoost clock speed and Hyper-Threading technology, which simulates the" +
                    " multitasking ability of a quad-core processor without the increased power " +
                    "consumption.");//prodDesc
            pstmt.execute();

            //ALL-IN-ONE
            //Product 3
            pstmt.setString(1, "ASUS");//prodMake
            pstmt.setString(2, "ET2221AUTR");//prodModel
            pstmt.setDouble(3, 739.99);//prodSalePrice
            pstmt.setDouble(4, 629.99);//prodCostPrice
            pstmt.setInt(5, 7);//prodQTY
            pstmt.setString(6, null);//prodPic
            pstmt.setString(7, "All-In-One");//prodType
            pstmt.setString(8, "AMD A8-5550M APU");//cpu
            pstmt.setString(9, "6 GB  - 1600 MHz");//ram
            pstmt.setString(10, "Windows 8");//operatingSystem
            pstmt.setString(11, "1 TB HDD");//storage
            pstmt.setString(12, "21.5\" Touchscreen");//screen
            pstmt.setString(13, "Open up your home computing with the fluid Asus ET2221AUTR 21.5 " +
                    "Touchscreen All-in-One PC. Powered by the new AMD Richland A-Series Accelerated " +
                    "Processing Unit (APU), the Asus ET2221 gives you up to 40% more performance than " +
                    "previous generations.");//prodDesc
            pstmt.execute();

            //ALL-IN-ONE
            //Product 4
            pstmt.setString(1, "ASUS");//prodMake
            pstmt.setString(2, "ET2221IUTH");//prodModel
            pstmt.setDouble(3, 899.99);//prodSalePrice
            pstmt.setDouble(4, 764.99);//prodCostPrice
            pstmt.setInt(5, 23);//prodQTY
            pstmt.setString(6, null);//prodPic
            pstmt.setString(7, "All-In-One");//prodType
            pstmt.setString(8, "Intel Core i3-4150T Processor");//cpu
            pstmt.setString(9, "8 GB  - 1600 MHz");//ram
            pstmt.setString(10, "Windows 8.1");//operatingSystem
            pstmt.setString(11, "1 TB HDD");//storage
            pstmt.setString(12, "21.5\" Touchscreen");//screen
            pstmt.setString(13, "A 4th generation Intel® Core™ i3-4150T processor and 8 GB of RAM provide " +
                    "quick, efficient processing that lets you work and play without worry. Save your " +
                    "photos, videos, songs and files on the generous 1 TB hard drive, which gives you more" +
                    " than enough room to keep all the items you need every day.");//prodDesc
            pstmt.execute();

            //ALL-IN-ONE
            //Product 5
            pstmt.setString(1, "HP");//prodMake
            pstmt.setString(2, "Pavilion 23-p030na");//prodModel
            pstmt.setDouble(3, 899.99);//prodSalePrice
            pstmt.setDouble(4, 764.99);//prodCostPrice
            pstmt.setInt(5, 17);//prodQTY
            pstmt.setString(6, null);//prodPic
            pstmt.setString(7, "All-In-One");//prodType
            pstmt.setString(8, "Intel Core i5-4590T Processor");//cpu
            pstmt.setString(9, "8 GB  - 1600 MHz");//ram
            pstmt.setString(10, "Windows 8");//operatingSystem
            pstmt.setString(11, "1 TB HDD");//storage
            pstmt.setString(12, "23\" Touchscreen");//screen
            pstmt.setString(13, "Bring together all your computing elements with the HP Pavilion 23-p030na" +
                    " 23\" Touchscreen All-in-One PC, featuring stunning graphics, easy entertainment and" +
                    " solid processing power.  Superior detail and colour reproduction deliver visuals that" +
                    " are rich and compelling, making everything from internet pages and photos to games" +
                    " and movies look as good as they should. You'll be able to take in this stunningly" +
                    " clear view from almost angle on this edge-to-edge screen.");//prodDesc
            pstmt.execute();

            //ALL-IN-ONE
            //Product 6
            pstmt.setString(1, "HP");//prodMake
            pstmt.setString(2, "ENVY 23-k210na");//prodModel
            pstmt.setDouble(3, 1299.99);//prodSalePrice
            pstmt.setDouble(4, 1004.99);//prodCostPrice
            pstmt.setInt(5, 11);//prodQTY
            pstmt.setString(6, null);//prodPic
            pstmt.setString(7, "All-In-One");//prodType
            pstmt.setString(8, "Intel Core i5-4590T Processor");//cpu
            pstmt.setString(9, "8 GB  - 1600 MHz");//ram
            pstmt.setString(10, "Windows 8");//operatingSystem
            pstmt.setString(11, "1 TB HDD");//storage
            pstmt.setString(12, "23\" Touchscreen");//screen
            pstmt.setString(13, "This All-in-One PC lets you stay comfortable while you're using your " +
                    "computer thanks to the revolutionary adjustable design. This means that you can" +
                    " position the touchscreen in four different ways, whether you pull it closer to you" +
                    " for close touch navigation work or put it upright to work on spreadsheets, watch " +
                    "movies or use the keyboard.");//prodDesc
            pstmt.execute();

            //ALL-IN-ONE
            //Product 7
            pstmt.setString(1, "ACER");//prodMake
            pstmt.setString(2, "Aspire U5-630");//prodModel
            pstmt.setDouble(3, 1399.99);//prodSalePrice
            pstmt.setDouble(4, 1189.99);//prodCostPrice
            pstmt.setInt(5, 5);//prodQTY
            pstmt.setString(6, null);//prodPic
            pstmt.setString(7, "All-In-One");//prodType
            pstmt.setString(8, "Intel Core i7-4702 processor");//cpu
            pstmt.setString(9, "8 GB  - 1600 MHz");//ram
            pstmt.setString(10, "Windows 8.1");//operatingSystem
            pstmt.setString(11, "1 TB HDD");//storage
            pstmt.setString(12, "23\" Touchscreen");//screen
            pstmt.setString(13, "With its Intel® Core™ i7-4702 processor, the Acer Aspire U5-630 23\"" +
                    " Touchscreen All-in-One PC runs incredibly quickly. CPU performance is 15% better " +
                    "than previous models, and applications load in half the time. The 8 GB of RAM allows" +
                    " for fluid multitasking and enhanced productivity for many different tasks.");//prodDesc
            pstmt.execute();

            //ALL-IN-ONE
            //Product 8
            pstmt.setString(1, "ACER");//prodMake
            pstmt.setString(2, "Aspire Z1-621");//prodModel
            pstmt.setDouble(3, 649.99);//prodSalePrice
            pstmt.setDouble(4, 549.99);//prodCostPrice
            pstmt.setInt(5, 14);//prodQTY
            pstmt.setString(6, null);//prodPic
            pstmt.setString(7, "All-In-One");//prodType
            pstmt.setString(8, "Intel Pentium Processor N3530");//cpu
            pstmt.setString(9, "4 GB  - 1600 MHz");//ram
            pstmt.setString(10, "Windows 8.1");//operatingSystem
            pstmt.setString(11, "1 TB HDD");//storage
            pstmt.setString(12, "21.5\" Touchscreen");//screen
            pstmt.setString(13, "The Aspire Z1 comes pre-installed with the simple yet expressive Windows " +
                    "8.1 operating system. Packed full of exciting apps, it gives you the information " +
                    "that's important to you whenever you need it. With Live Tiles, your applications " +
                    "update in real time, so whether you need up the minute news or an integrated email " +
                    "client, there's an app to keep you current in Windows 8.1.");//prodDesc
            pstmt.execute();

            //ALL-IN-ONE
            //Product 9
            pstmt.setString(1, "PACKARD BELL");//prodMake
            pstmt.setString(2, "OneTwo S 3280");//prodModel
            pstmt.setDouble(3, 449.99);//prodSalePrice
            pstmt.setDouble(4, 379.99);//prodCostPrice
            pstmt.setInt(5, 18);//prodQTY
            pstmt.setString(6, null);//prodPic
            pstmt.setString(7, "All-In-One");//prodType
            pstmt.setString(8, "AMD A4-6210 APU");//cpu
            pstmt.setString(9, "4 GB  - 1600 MHz");//ram
            pstmt.setString(10, "Windows 8.1");//operatingSystem
            pstmt.setString(11, "1 TB HDD");//storage
            pstmt.setString(12, "19.5\" Touchscreen");//screen
            pstmt.setString(13, "You've got the power to get everyday tasks done thanks to the AMD A4 " +
                    "processor at the centre of this All-in-One, with 4 GB of memory to keep multitasking" +
                    " smooth. If you find you need more memory to get things done, you can choose to " +
                    "expand the memory up to a whopping 16 GB. A 1 TB hard drive provides ample space for" +
                    " the whole family to be able to store their files, whether it's the photos from the " +
                    "summer holiday or everyone's favourite music.\n");//prodDesc
            pstmt.execute();

            //ALL-IN-ONE
            //Product 10
            pstmt.setString(1, "LENOVO");//prodMake
            pstmt.setString(2, "C40");//prodModel
            pstmt.setDouble(3, 559.99);//prodSalePrice
            pstmt.setDouble(4, 379.99);//prodCostPrice
            pstmt.setInt(5, 17);//prodQTY
            pstmt.setString(6, null);//prodPic
            pstmt.setString(7, "All-In-One");//prodType
            pstmt.setString(8, "Intel Pentium Processor 3558U");//cpu
            pstmt.setString(9, "6 GB - 1600 MHz");//ram
            pstmt.setString(10, "Windows 8.1");//operatingSystem
            pstmt.setString(11, "1 TB SATA HDD");//storage
            pstmt.setString(12, "21.5\" LED");//screen
            pstmt.setString(13, "The all-in-one design of the Lenovo C40 frees up desk space, while " +
                    "seamlessly fitting into any environment such as your study, living room or bedroom. " +
                    "Great for entertainment, the Lenovo C40 features a DVD/RW drive for watching movies " +
                    "and Wi-Fi connectivity for streaming or downloading videos. Sound is enhanced thanks" +
                    " to Dolby Home Theatre technology. The contemporary Lenovo C40 21.5\" All-in-One PC " +
                    "is fun and functional for the whole family.\n");//prodDesc
            pstmt.execute();





        } catch (SQLException e) {
            System.out.println("Error creating table");
        }
    }

}
