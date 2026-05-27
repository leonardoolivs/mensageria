package br.com.boleto.controllers;

import br.com.boleto.dtos.BoletoDTO;
import br.com.boleto.entities.Boleto;
import br.com.boleto.services.BoletoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/boletos")
public class BoletoController {

    private final BoletoService service;

    @PostMapping
    public ResponseEntity<BoletoDTO> criar(@RequestBody Boleto boleto){

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(boleto.getId()).toUri();

        BoletoDTO dto = service.criar(boleto);

        return ResponseEntity.created(uri).body(dto);
    }

}
