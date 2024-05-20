package org.example.service;

import org.example.dao.NinjasDao;
import org.example.dao.NinjasDaoJpa;
import org.example.dao.PirataDao;
import org.example.dao.PirataDaoJpa;
import org.example.entity.Ninja;

import java.util.List;
public class NinjasServic {
    private NinjasDao ninjasDao = new NinjasDaoJpa();

    public void jonin (){
        List<Ninja> jonins = ninjasDao.findJonin();
        for (Ninja n: jonins){
            System.out.println(n.getNombre());
            System.out.println(n.getAldea());
            System.out.println(n.getRango());
            System.out.println(n.getMision());
            System.out.println(n.getChakra());
        }
    }
}
