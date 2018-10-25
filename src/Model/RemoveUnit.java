package Model;

import static Model.Done.User;
import static Model.Done.user1;
import static Model.Done.user2;

public class RemoveUnit extends Requests {

    public RemoveUnit(int blockid, int unitId) {
        if (User.equals(user1)) {
            for (Block block : user1.city1.ArrayListblocks) {
                for (Bazar bazar : block.getBazarArrayList()) {
                    if (bazar.getId() == unitId && block.getId() == blockid) {
                        block.RemoveBazarArray(bazar);
                        if (unitId == user1.city1.nextid.getNextId()) {
                            user1.city1.nextid.setNextId(unitId - 1);
                            user1.setGills(user1.getGills() + 500);
                        }
                    }
                    for (Army army : block.getArmyArrayList()) {
                        if (army.getId() == unitId && block.getId() == blockid) {
                            block.RemoveArmyArray(army);
                            if (unitId == user1.city1.nextid.getNextId()) {
                                user1.city1.nextid.setNextId(unitId - 1);
                                user1.setGills(user1.getGills() + 10000);
                            }
                        }
                        for (Padafand padafand : block.getPadafandArrayList()) {
                            if (padafand.getId() == unitId && block.getId() == blockid) {
                                block.RemovePadafandArray(padafand);
                                if (unitId == user1.city1.nextid.getNextId()) {
                                    user1.city1.nextid.setNextId(unitId - 1);
                                    user1.setGills(user1.getGills() + 10000);
                                }
                            }
                            for (House house : block.getHouseArrayList()) {
                                if (house.getId() == unitId && block.getId() == blockid) {
                                    block.RemoveHouseArray(house);
                                    if (unitId == user1.city1.nextid.getNextId()) {
                                        user1.city1.nextid.setNextId(unitId - 1);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } else {
            for (Block block : user2.city2.ArrayListblocks) {
                for (Bazar bazar : block.getBazarArrayList()) {
                    if (bazar.getId() == unitId && block.getId() == blockid) {
                        block.RemoveBazarArray(bazar);
                        if (unitId == user2.city2.nextid.getNextId()) {
                            user2.city2.nextid.setNextId(unitId - 1);
                            user2.setGills(user2.getGills() + 500);
                            block.setScoreForPersonsForRemovingBazar(bazar);
                        }
                    }
                    for (Army army : block.getArmyArrayList()) {
                        if (army.getId() == unitId && block.getId() == blockid) {
                            block.RemoveArmyArray(army);
                            if (unitId == user2.city2.nextid.getNextId()) {
                                user2.city2.nextid.setNextId(unitId - 1);
                                user2.setGills(user2.getGills() + 10000);
                            }
                        }
                        for (Padafand padafand : block.getPadafandArrayList()) {
                            if (padafand.getId() == unitId && block.getId() == blockid) {
                                block.RemovePadafandArray(padafand);
                                if (unitId == user2.city2.nextid.getNextId()) {
                                    user2.city2.nextid.setNextId(unitId - 1);
                                    user2.setGills(user2.getGills() + 10000);
                                }
                            }
                            for (House house : block.getHouseArrayList()) {
                                if (house.getId() == unitId && block.getId() == blockid) {
                                    block.RemoveHouseArray(house);
                                    if (unitId == user2.city2.nextid.getNextId()) {
                                        user2.city2.nextid.setNextId(unitId - 1);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
