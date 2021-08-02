
package com.rainmonth.pattern.behavioral.templatemethod;

public abstract class CaffeineBeverage {

    private boolean isNeedToAddCondiments = true;

    /**
     * 通用算法
     * 大体的制作流程
     */
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    /**
     * 不同的部分，由子类实现
     */
    protected abstract void brew();

    /**
     * 不同的部分，由子类实现
     */
    protected abstract void addCondiments();

    private void boilWater() {
        System.out.println("Boiling water");
    }

    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    /**
     * 询问是否需要额外添加品（牛奶和糖）
     * @return true if needed
     */
    public boolean customerWantsCondiments() {
        return isNeedToAddCondiments;
    }

    /**
     * 设置是否需要额外添加品
     */
    public void setCustomerWantsCondiments(boolean needToAddCondiment) {
        isNeedToAddCondiments = needToAddCondiment;
    }
}
