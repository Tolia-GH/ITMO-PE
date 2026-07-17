import asyncio

async def prepare_ingredients(ingredients): # 备菜
    print("Begin preparing ingredients")
    await asyncio.sleep(200)
    print("Ingredients are prepared")

    return "prepared " + ingredients

async def boil_water(water):  # 烧水
    print("Begin boiling water")
    await asyncio.sleep(300)
    print("Water is ready")

    return "hot " + water

async def cook(meal):
    task_prepare_vegetable = asyncio.create_task(prepare_ingredients("vegetable"))
    task_boil_water = asyncio.create_task(boil_water("water"))

    vegetable = await task_prepare_vegetable
    water = await task_boil_water

    meal = meal + ": " + vegetable + ", " + water

    return meal

if __name__ == "__main__":
    results = asyncio.run(cook("Soup"))
    print(results)
