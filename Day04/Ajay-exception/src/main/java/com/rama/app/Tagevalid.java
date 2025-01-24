package com.rama.app;

class AgeValid extends Exception {
    public AgeValid(String message) {
        super(message);
    }
}
class Tagevalid {
    public static void main(String[] args) {
        //AgeValid obj=new AgeValid();
        try{
            validateAge(30);
        }catch(AgeValid e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }finally{
            System.out.println("This Code Will always Executes");
        }
    }

    public static void validateAge(int age) throws AgeValid {
        if (age!=21) {
            throw new AgeValid("This Age is not Ajay's Age.");
        }
    }
}
