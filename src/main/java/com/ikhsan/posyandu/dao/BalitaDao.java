/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ikhsan.posyandu.dao;

import com.ikhsan.posyandu.entity.Balita;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author feda
 */
public interface BalitaDao extends PagingAndSortingRepository<Balita, String>{
    
}
