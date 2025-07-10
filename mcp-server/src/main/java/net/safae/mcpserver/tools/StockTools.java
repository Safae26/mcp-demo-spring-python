package net.safae.mcpserver.tools;

import org.springframework.stereotype.Service;
import java.util.List;
import java.time.LocalDate;
import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.agent.tool.Description;

@Service
public class StockTools {
    private final List<Company> companies = List.of(
            new Company("Google", "Technology", 182.5, 156500, "United States"),
            new Company("Maroc Telecom", "Networks", 38.26, 88000, "Maroc")
    );

    @Tool(description = "Get All Companies")
    public List<Company> getAllCompanies() {
        return companies;
    }

    @Tool
    public Company getCompanyByName(String name) {
        return companies.stream()
                .filter(c -> c.name().equals(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Company not found"));
    }

    @Tool
    public Stock getStockByCompanyName(String name) {
        return new Stock(name, LocalDate.now(), 300 + Math.random() * 300);
    }
}

record Company(String name,
               String activity,
               @Description("The turn In Milliard MAD") double turnover,
               int employeesCount,
               String country) {}

record Stock(String companyName, LocalDate date, double stock) {}