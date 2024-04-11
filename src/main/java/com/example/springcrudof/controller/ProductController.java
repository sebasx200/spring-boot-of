package com.example.springcrudof.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springcrudof.service.ProductServive;

import com.example.springcrudof.domain.Product;

@Controller
public class ProductController {

    @Autowired
    private ProductServive productService;

    @GetMapping("/product-form")
    public String showProductForm(Model model) {

        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);

        model.addAttribute("product", new Product());
        return "product-form";

    }

    @PostMapping("/save-product")
    public String guardarProducto(@ModelAttribute Product product, Model model) {
            // Si el ID ya existe, agregar un mensaje de error y volver al formulario
            model.addAttribute("errorMessage", "El ID ya está en uso. Por favor, ingrese un ID diferente.");
            productService.saveProduct(product);
            List<Product> products = productService.getAllProducts();
            model.addAttribute("products", products);
            return "redirect:/product-form";
    }

    @GetMapping("/eliminar-producto/{id}")
    public String eliminarProducto(Model model, @PathVariable(name = "id") Long id) {
        productService.deleteProduct(id);
        return "redirect:/product-form"; // Redirige a la página principal
    }

    @GetMapping("/editar-producto/{id}")
public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
    // Obtener el producto correspondiente desde la base de datos
    Product product = productService.findById(id);
    
    // Agregar el producto al modelo para que se muestre en el formulario de edición
    model.addAttribute("editingMode", true);
    model.addAttribute("product", product);
    List<Product> products = productService.getAllProducts();
            model.addAttribute("products", products);
    
    // Renderizar la vista del formulario de edición
    productService.saveProduct(product);
    return "update-form";

}


}
