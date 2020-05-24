package com.example.myapplication;

public class UserCart {
    private BP bp;
    private Body body;
    private CPU cpu;
    private Coolers coolers;
    private HDD hdd;
    private M2 m2;
    private Motherboards motherboards;
    private RAM ram;
    private SSD ssd;
    private GPU gpu;
    private CoolersCPU coolersCPU;

    public UserCart() {
    }

    public UserCart(BP bp, Body body, CPU cpu, Coolers coolers, HDD hdd, M2 m2, Motherboards motherboards, RAM ram, SSD ssd, GPU gpu, CoolersCPU coolersCPU) {
        this.bp = bp;
        this.body = body;
        this.cpu = cpu;
        this.coolers = coolers;
        this.hdd = hdd;
        this.m2 = m2;
        this.motherboards = motherboards;
        this.ram = ram;
        this.ssd = ssd;
        this.gpu = gpu;
        this.coolersCPU = coolersCPU;
    }
    public BP getBp() {
        return bp;
    }

    public void setBp(BP bp) {
        this.bp = bp;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public CPU getCpu() {
        return cpu;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public Coolers getCoolers() {
        return coolers;
    }

    public void setCoolers(Coolers coolers) {
        this.coolers = coolers;
    }

    public HDD getHdd() {
        return hdd;
    }

    public void setHdd(HDD hdd) {
        this.hdd = hdd;
    }

    public M2 getM2() {
        return m2;
    }

    public void setM2(M2 m2) {
        this.m2 = m2;
    }

    public Motherboards getMotherboards() {
        return motherboards;
    }

    public void setMotherboards(Motherboards motherboards) {
        this.motherboards = motherboards;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public SSD getSsd() {
        return ssd;
    }

    public void setSsd(SSD ssd) {
        this.ssd = ssd;
    }

    public GPU getGpu() {
        return gpu;
    }

    public void setGpu(GPU gpu) {
        this.gpu = gpu;
    }

    public CoolersCPU getCoolersCPU() {
        return coolersCPU;
    }

    public void setCoolersCPU(CoolersCPU coolersCPU) {
        this.coolersCPU = coolersCPU;
    }

    public double getAmount(){
        double amount = 0;

        if (bp!= null){
            amount+= Double.parseDouble(bp.getPrice());
        }
        if(body != null){
            amount+= Double.parseDouble(body.getPrice());
        }
        if(cpu != null){
            amount+= Double.parseDouble(cpu.getPrice());
        }
        if(coolers != null){
            amount+= Double.parseDouble(coolers.getPrice());
        }
        if(hdd != null){
            amount+= Double.parseDouble(hdd.getPrice());
        }
        if(m2 != null){
            amount+= Double.parseDouble(m2.getPrice());
        }
        if(motherboards != null){
            amount+= Double.parseDouble(motherboards.getPrice());
        }
        if(ram != null){
            amount+= Double.parseDouble(ram.getPrice());
        }
        if(ssd != null){
            amount+= Double.parseDouble(ssd.getPrice());
        }
        if(gpu != null){
            amount+= Double.parseDouble(gpu.getPrice());
        }
        if(coolersCPU != null){
            amount+= Double.parseDouble(coolersCPU.getPrice());
        }

        return amount;
    }
}
