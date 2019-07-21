/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.util.concurrent.Future;
import javax.ejb.Local;

/**
 *
 * @author MD-Aseef
 */
@Local
public interface NewSessionBeanLocal {
    public void init(Future obj,int time);
    public Future<Long> calprimebelow(long upperlimit);
}
