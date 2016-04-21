/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ikhsan.posyandu.dao;

import com.ikhsan.posyandu.entity.Orangtua;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author feda
 */
public interface OrangtuaDao extends PagingAndSortingRepository<Orangtua, String>{
    
}
