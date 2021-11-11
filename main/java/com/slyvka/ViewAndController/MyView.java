package com.slyvka.ViewAndController;

import com.slyvka.model.*;
import com.slyvka.service.*;

import java.awt.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.List;

public class MyView {

    private Map<String, String> menu;
    private Map<String, Printable> methodsMenu;
    private String selectedTable;
    Scanner input = new Scanner(System.in);

    public MyView() {
        menu = new LinkedHashMap<>();
        menu.put("A", "    A - Select all tables");

        menu.put("1", "    1 - Table:Landlord");
        menu.put("2", "    2 - Table:Tenant");
        menu.put("3", "    3 - Table:City");
        menu.put("4", "    4 - Table:Street");
        menu.put("5", "    5 - Table:Country");
        menu.put("6", "    6 - Table:MoneyTransfer");
        menu.put("FF", "    FF - Select by id");
        menu.put("CC", "    CC - Create");
        menu.put("UU", "    UU - Update");
        menu.put("DD", "    DD - Delete");


        menu.put("Q", "   Q - exit");

        methodsMenu = new LinkedHashMap<>();
//        methodsMenu.put("A", this::selectAllTable)
        methodsMenu.put("1", this::selectLandlord);
        methodsMenu.put("2", this::selectTenant);
        methodsMenu.put("3", this::selectCity);
        methodsMenu.put("4", this::selectStreet);
        methodsMenu.put("5", this::selectCountry);
        methodsMenu.put("6", this::selectMoneyTransfer);
        methodsMenu.put("FF", this::findById);
        methodsMenu.put("CC", this::create);
        methodsMenu.put("UU", this::update);
        methodsMenu.put("DD", this::delete);
    }

    private void selectLandlord() throws SQLException {
        selectedTable = "landlord";
        System.out.println("Landlord:");
        List<LandlordEntity> landlords = new LandlordService().findAll();
        for(LandlordEntity landlord: landlords)
            System.out.println(landlord);
    }

    private void selectTenant() throws SQLException {
        selectedTable = "tenant";
        System.out.println("Tenant:");
        List<TenantEntity> entities = new TenantService().findAll();
        for(TenantEntity entity: entities)
            System.out.println(entity);
    }

    private void selectCity() throws SQLException {
        selectedTable = "city";
        System.out.println("City:");
        List<CityEntity> entities = new CityService().findAll();
        for(CityEntity entity: entities)
            System.out.println(entity);
    }

    private void selectStreet() throws SQLException {
        selectedTable = "street";
        System.out.println("Street:");
        List<StreetEntity> entities = new StreetService().findAll();
        for(StreetEntity entity: entities)
            System.out.println(entity);
    }

    private void selectCountry() throws SQLException {
        selectedTable = "country";
        System.out.println("Country:");
        List<CountryEntity> entities = new CountryService().findAll();
        for(CountryEntity entity: entities)
            System.out.println(entity);
    }

    private void selectMoneyTransfer() throws SQLException {
        selectedTable = "money_transfer";
        System.out.println("Money transfer:");
        List<MoneyTransferEntity> entities = new MoneyTransferService().findAll();
        for(MoneyTransferEntity entity: entities)
            System.out.println(entity);
    }

    private void findById() throws SQLException {
        System.out.println("Write id");
        switch (selectedTable) {
            case "landlord":
                int id = Integer.parseInt(input.nextLine());
                System.out.println(new LandlordService().findById(id));
                break;
            case "tenant":
                id = Integer.parseInt(input.nextLine());
                System.out.println(new TenantService().findById(id));
                break;
            case "city":
                String name = input.nextLine();
                System.out.println(new CityService().findById(name));
                break;
            case "street":
                name = input.nextLine();
                System.out.println(new StreetService().findById(name));
                break;
            case "country":
                name = input.nextLine();
                System.out.println(new CountryService().findById(name));
                break;
            case "money_transfer":
                id = Integer.parseInt(input.nextLine());
                System.out.println(new MoneyTransferService().findById(id));
                break;
        }
    }

    private void create() throws SQLException, ParseException {
        switch (selectedTable) {
            case "landlord":
                System.out.println("id");
                int id = Integer.parseInt(input.nextLine());
                System.out.println("name");
                String name = input.nextLine();
                System.out.println("surname");
                String surname = input.nextLine();
                System.out.println("money");
                float money = Float.parseFloat(input.nextLine());

                new LandlordService().create(new LandlordEntity(id, name, surname, money));
                break;
            case "tenant":
                System.out.println("id");
                id = Integer.parseInt(input.nextLine());
                System.out.println("name");
                name = input.nextLine();
                System.out.println("surname");
                surname = input.nextLine();
                System.out.println("money");
                money = Float.parseFloat(input.nextLine());
                new TenantService().create(new TenantEntity(id, name, surname, money));
                break;
            case "city":
                System.out.println("name");
                name = input.nextLine();
                new CityService().create(new CityEntity(name));
                break;
            case "street":
                System.out.println("name");
                name = input.nextLine();
                new StreetService().create(new StreetEntity(name));
                break;
            case "country":
                System.out.println("name");
                name = input.nextLine();
                new CountryService().create(new CountryEntity(name));
                break;
            case "money_transfer":
                System.out.println("id");
                id = Integer.parseInt(input.nextLine());
                System.out.println("time");
                SimpleDateFormat dateInput = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String timeStr = input.nextLine();
                Date timeUtil = dateInput.parse(timeStr);
                java.sql.Date timeSQL = java.sql.Date.valueOf(String.valueOf(timeUtil));
                System.out.println("money");
                money = Float.parseFloat(input.nextLine());
                System.out.println("is_sent");
                boolean isSent = Boolean.parseBoolean(input.nextLine());
                System.out.println("may_be_received");
                boolean mayBeReceived = Boolean.parseBoolean(input.nextLine());
                System.out.println("is_received");
                boolean isReceived = Boolean.parseBoolean(input.nextLine());
                System.out.println("landlord_id");
                int landlordID = Integer.parseInt(input.nextLine());
                System.out.println("tenant_id");
                int tenantID = Integer.parseInt(input.nextLine());
                new MoneyTransferService().create(new MoneyTransferEntity(id, timeSQL, money, isSent, mayBeReceived,
                        isReceived, landlordID, tenantID));
                break;
        }
    }

    private void update() throws SQLException, ParseException {
        switch (selectedTable) {
            case "landlord":
                System.out.println("id to update");
                int id = Integer.parseInt(input.nextLine());
                System.out.println("name");
                String name = input.nextLine();
                System.out.println("surname");
                String surname = input.nextLine();
                System.out.println("money");
                float money = Float.parseFloat(input.nextLine());

                System.out.println(new LandlordService().update(new LandlordEntity(id, name, surname, money)));
                break;
            case "tenant":
                System.out.println("id to update");
                id = Integer.parseInt(input.nextLine());
                System.out.println("name");
                name = input.nextLine();
                System.out.println("surname");
                surname = input.nextLine();
                System.out.println("money");
                money = Float.parseFloat(input.nextLine());

                System.out.println(new TenantService().update(new TenantEntity(id, name, surname, money)));
                break;
            case "money_transfer":
                System.out.println("id to update");
                id = Integer.parseInt(input.nextLine());
                System.out.println("time");
                SimpleDateFormat dateInput = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String timeStr = input.nextLine();
                Date timeUtil = dateInput.parse(timeStr);
                java.sql.Date timeSQL = java.sql.Date.valueOf(String.valueOf(timeUtil));
                System.out.println("money");
                money = Float.parseFloat(input.nextLine());
                System.out.println("is_sent");
                boolean isSent = Boolean.parseBoolean(input.nextLine());
                System.out.println("may_be_received");
                boolean mayBeReceived = Boolean.parseBoolean(input.nextLine());
                System.out.println("is_received");
                boolean isReceived = Boolean.parseBoolean(input.nextLine());
                System.out.println("landlord_id");
                int landlordID = Integer.parseInt(input.nextLine());
                System.out.println("tenant_id");
                int tenantID = Integer.parseInt(input.nextLine());
                System.out.println(new MoneyTransferService().update(new MoneyTransferEntity(id, timeSQL, money, isSent, mayBeReceived,
                        isReceived, landlordID, tenantID)));
                break;
        }
    }

    private void delete() throws SQLException {
        System.out.println("id to delete");
        int id = Integer.parseInt(input.nextLine());

        switch (selectedTable) {
            case "landlord":
                System.out.println(new LandlordService().delete(id));
                break;
            case "money_transfer":
                System.out.println(new MoneyTransferService().delete(id));
                break;
        }
    }

    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String key: menu.keySet())
            if(key.length() == 1) System.out.println(menu.get(key));
    }

    private void outputSubMenu() {
        System.out.println("\nSubMenu:");
        for (String key: menu.keySet())
            if (key.length() != 1) System.out.println(menu.get(key));
    }

    public void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please select menu point");
            keyMenu = input.nextLine().toUpperCase();

            if (keyMenu.equals("Q")) {break;}

            if (keyMenu.matches("^\\d")) {
                try {
                    methodsMenu.get(keyMenu).print();
                } catch (SQLException | ParseException e) {
                    e.printStackTrace();
                }
                outputSubMenu();
                System.out.println("Please, select menu point");
                keyMenu = input.nextLine().toUpperCase();
            }

            try {
                methodsMenu.get(keyMenu).print();
            } catch (SQLException | ParseException e) {
                e.printStackTrace();
            }
        } while (!keyMenu.equals("Q"));
    }
}
