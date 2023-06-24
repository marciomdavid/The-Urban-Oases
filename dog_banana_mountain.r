# This script aims to produce a visualization of the Urban Oases in the United States.

# 1. First, we will install the necessary packages.
install.packages('ggplot2')
install.packages('maps')

# 2. We will then load the ggplot2 and maps packages.
library(ggplot2)
library(maps)

# 3. Next, we will load the US map from the maps package.
us_map = map_data("state")

# 4. Now, we will load the data from the Urban Oases dataset.
urban_oases_data = read.csv("Urban_Oases_Data.csv")

# 5. We will then add a column to the urban_oases_data dataset to identify each state.
urban_oases_data$state = tolower(gsub("\\s+", "", urban_oases_data$state))

# 6. Next, we will filter the data in the urban_oases_data dataset to only include oases.
urban_oases_data = subset(urban_oases_data, type == 'Oasis')

# 7. We will then join the us_map and urban_oases_data datasets using the ‘state’ column.
urban_oases_data = merge(urban_oases_data, 
                         us_map, 
                         by.x = "state", 
                         by.y = "region")

# 8. We will now create a vector of oasis types.
oasis_types = unique(urban_oases_data$sub_type)

# 9. We will then create a vector of colors to use when plotting the oases.
oasis_colors = c("#FF0000", "#00FF00", "#0000FF", "#FFFF00", "#00FFFF", 
                 "#FF00FF", "#000000", "#666666", "#999999", "#CCCCCC")

# 10. We will now set the plot theme for the oases visualization.
theme_set(theme_bw())

# 11. We will then iterate through oasis_types vector and create the visualization.
plot_list = list()

for (i in 1:length(oasis_types)) {
  type = oasis_types[i]
  color = oasis_colors[i]
  
  current_oases = subset(urban_oases_data, sub_type == type)
  
  # Create a subset of the data for each type of oasis.
  current_plot = ggplot() +
    geom_polygon(data = us_map, 
                aes(x = long, y = lat, group = group), 
                fill = "white", color = "black") +
    geom_point(data = current_oases, 
               aes(x = long, y = lat, group = sub_type, color = sub_type), 
               size = 2, alpha = 0.8, shape = 21) +
    scale_color_manual(values = color) + 
    labs(title = type, fill = type)
  
  # Append the plot to the plot_list.
  plot_list[[i]] = current_plot
}

# 12. Finally, we will plot all of the oases visualizations using the gridExtra package.
library(gridExtra)
grid.arrange(plotlist = plot_list, ncol = 3)